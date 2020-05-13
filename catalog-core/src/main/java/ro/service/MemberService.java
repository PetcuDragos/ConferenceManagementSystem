package ro.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.domain.MyUser;
import ro.repository.*;
import ro.utils.Message;

import java.util.List;

@Service
public class MemberService {

    public static final Logger log = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private PcMemberRepository pcMemberRepository;
    @Autowired
    private ScMemberRepository scMemberRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CChairRepository cChairRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private ConferenceRepository conferenceRepository;

    public MemberService() {
    }

    public Message<MyUser> login(String username, String password){
        log.trace("login function - entered");
        List<MyUser> users = this.myUserRepository.findAll();
        boolean username_found = false;
        for(MyUser user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return new Message<MyUser>(user, "");
            if (user.getUsername().equals(username)) username_found = true;
        }
        if(username_found) return new Message<MyUser>(null,"Password was incorrect");
        else return new Message<MyUser>(null,"There was no account with this username");
    }

    public Message<MyUser> register(String username, String password, String email){
        log.trace("memberService - register function - entered");
        List<MyUser> users = this.myUserRepository.findAll();
        for(MyUser user : users) {
            if(user.getEmail().equals(email))
                return new Message<MyUser>(null,"Email is already being used");
            if(user.getUsername().equals(username))
                return new Message<MyUser>(null,"Username is already being used");
        }
        MyUser user = new MyUser(username,password,email);
        this.myUserRepository.save(user);
        return new Message<MyUser>(user, "");
    }
}
