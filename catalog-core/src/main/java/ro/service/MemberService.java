package ro.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.domain.*;
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
    private ConferenceRepository conferenceRepository;

    public MemberService() {
    }

    public List<MyUser> getAllMembers() {
        return this.myUserRepository.findAll();
    }

    public List<PcMember> getPcMembers() {
        return this.pcMemberRepository.findAll();
    }

    public List<ScMember> getScMembers() {
        return this.scMemberRepository.findAll();
    }

    public List<Author> getAuthors() {
        return this.authorRepository.findAll();
    }

    public List<CChair> getCChairs() {
        return this.cChairRepository.findAll();
    }

    public List<Conference> getConferences() {
        return this.conferenceRepository.findAll();
    }

    public Message<PcMember> addPcMember(Long conferenceId, Long userId) {
        List<PcMember> pcMembers = this.pcMemberRepository.findAll();
        for(PcMember pcMember : pcMembers)
            if(pcMember.getConference_id().equals(conferenceId) && pcMember.getUser_id().equals(userId))
                return new Message<>(null, "You are already a pcMember at this conference");
        PcMember pcMember = new PcMember(conferenceId, userId);
        this.pcMemberRepository.save(pcMember);
        return new Message<>(pcMember,"");
    }

    public Message<ScMember> addScMember(Long conferenceId, Long userId) {
        List<ScMember> scMembers = this.scMemberRepository.findAll();
        for(ScMember scMember : scMembers)
            if(scMember.getConference_id().equals(conferenceId) && scMember.getUser_id().equals(userId))
                return new Message<>(null, "You are already a ScMember at this conference!");
        ScMember scMember = new ScMember(conferenceId, userId);
        this.scMemberRepository.save(scMember);
        return new Message<>(scMember, "");
    }

    public Message<CChair> addCChair(Long pcMember) {
        List<CChair> cChairs = this.cChairRepository.findAll();
        for (CChair cChair : cChairs)
            if (cChair.getPc_id().equals(pcMember))
                return new Message<>(null, "You are already a chair here!");
        CChair chair = new CChair(pcMember);
        this.cChairRepository.save(chair);
        return new Message<>(chair, "");
    }

    public MyUser getUserFromUsername(String username) {
        log.trace("getUserFromUsername - method entered");
        List<MyUser> users = this.myUserRepository.findAll();
        for (MyUser user : users) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    public void updateProfile(String username, String fullname, String email, String affiliation, String webpage) {
        log.trace("updateProfile - method entered");
        MyUser user = this.getUserFromUsername(username);
        if (user != null) {
            user.setFullName(fullname);
            user.setEmail(email);
            user.setAffiliation(affiliation);
            user.setWeb_page(webpage);
        }
    }

    public Message<MyUser> login(String username, String password) {
        log.trace("login function - entered");
        List<MyUser> users = this.myUserRepository.findAll();
        boolean username_found = false;
        for (MyUser user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return new Message<MyUser>(user, "");
            if (user.getUsername().equals(username)) username_found = true;
        }
        if (username_found) return new Message<MyUser>(null, "Password was incorrect");
        else return new Message<MyUser>(null, "There was no account with this username");
    }

    public Message<MyUser> register(String username, String password, String email) {
        log.trace("memberService - register function - entered");
        List<MyUser> users = this.myUserRepository.findAll();
        for (MyUser user : users) {
            if (user.getEmail().equals(email))
                return new Message<MyUser>(null, "Email is already being used");
            if (user.getUsername().equals(username))
                return new Message<MyUser>(null, "Username is already being used");
        }
        MyUser user = new MyUser(username, password, email);
        this.myUserRepository.save(user);
        return new Message<MyUser>(user, "");
    }

}
