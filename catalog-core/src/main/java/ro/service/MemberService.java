package ro.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.domain.MyUser;
import ro.repository.*;

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

    public MyUser login(String username, String password){
        log.trace("login function - entered");
        List<MyUser> users = this.myUserRepository.findAll();
        for(MyUser user : users)
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        return null;
    }
}
