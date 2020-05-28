package ro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.converter.MemberConverter;
import ro.domain.MyUser;
import ro.domain.Newsletter;
import ro.dto.*;
import ro.hardcodedMain.Console;
import ro.service.MemberService;
import ro.utils.Message;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthController {
    public static final Logger log = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private MemberService serviceMember;

    @Autowired
    private MemberConverter memberConverter;

    @Autowired
    private Console console;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Message<MyUser> login(@RequestBody LoginDto loginDto) {
        log.trace("Controller - login - {}", loginDto);
        try {
            Message<MyUser> result = serviceMember.login(loginDto.getUsername(),loginDto.getPassword());
            log.trace("Controller - login worked saved");
            return result;
        } catch (Exception e) {
            log.trace("Controller - login failed. Error: \n {}", e.toString());
        }
        return new Message<MyUser>(null,"error");
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Message<MyUser> register(@RequestBody RegisterDto registerDto) {
        log.trace("Controller - register - {}", registerDto);
        try {
            Message<MyUser> result = serviceMember.register(registerDto.getUsername(),registerDto.getPassword(),
                    registerDto.getVerifyPassword(), registerDto.getEmail(), registerDto.getFullName(),
                    registerDto.getAffiliation(), registerDto.getUserWebsite());
            if(result.getEntity() != null) log.trace("Controller - register successful");
            else log.trace("Controller - register unsuccessful, email or username used.");
            return result;
        } catch (Exception e) {
            log.trace("Controller - register failed. Error: \n {}", e.toString());
        }
        return new Message<MyUser>(null,"error");
    }

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public List<MemberDto> getMembers() {
            try{
                console.runConsole();
            }
            catch(Exception e){
                log.trace(e.toString());
            }
            return new ArrayList<MemberDto>(this.memberConverter.convertModelsToDtos(serviceMember.getAllMembers()));
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public Message<MyUser> saveProfile(@RequestBody ProfilePageDto profilePageDto){
        log.trace("Controller - saveProfile - {}", profilePageDto);
        try{
            Message<MyUser> result = this.serviceMember.updateProfile(profilePageDto.getUsername(),
                    profilePageDto.getFullName(), profilePageDto.getEmail(), profilePageDto.getAffiliation(),
                    profilePageDto.getWebpage());
            if(result.getEntity() != null) log.trace("Controller - saveProfile successful");
            else log.trace("Controller - saveProfile unsuccessful");
            return result;
        }
        catch (Exception e){
            log.trace("Controller - saveProfile failed. Error: \n {}", e.toString());
        }
        return new Message<MyUser>(null,"error");
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET, params = {"username"})
    public ProfilePageDto sendProfile(@RequestParam("username") String username){
        log.trace("Controller - saveProfile - {}", username);
        try{
            MyUser userFromUsername = serviceMember.getUserFromUsername(username);
            if (userFromUsername != null)
            {
                return new ProfilePageDto(userFromUsername.getUsername(),userFromUsername.getFullName(),userFromUsername.getEmail(),userFromUsername.getAffiliation(),userFromUsername.getWeb_page());
            }
            else
                return null;
        }
        catch (Exception e){
            log.trace("Controller - saveProfile failed. Error: \n {}", e.toString());
        }
        return null;
    }

    @RequestMapping(value = "/scmembers", method = RequestMethod.GET, params = {"username"})
    public boolean checkIfScMember(@RequestParam("username") String username) {
        MyUser user = serviceMember.getUserFromUsername(username);
        if (user!=null) {
            Long user_id = user.getId();
            return this.serviceMember.getScMembers().stream().anyMatch(t -> user_id.equals(t.getUser_id()));
        }
        return false;
    }

    @RequestMapping(value = "/newsletter", method = RequestMethod.POST)
    public Message<Newsletter> newsletter(@RequestBody NewsletterDto newsletterDto) {
        log.trace("Controller - newsletter - {}", newsletterDto);
        try {
            Message<Newsletter> result = serviceMember.subscribeToNewsletter(newsletterDto.getName(),newsletterDto.getEmail(),
                    newsletterDto.getDailyNewsletter());
            if(result.getEntity() != null) log.trace("Controller - newsletter successful");
            else log.trace("Controller - newsletter unsuccessful, email used or one field empty.");
            return result;
        } catch (Exception e) {
            log.trace("Controller - newsletter failed. Error: \n {}", e.toString());
        }
        return new Message<Newsletter>(null,"error");
    }
}
