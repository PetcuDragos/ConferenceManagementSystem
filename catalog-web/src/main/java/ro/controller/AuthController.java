package ro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.converter.MemberConverter;
import ro.domain.MyUser;
import ro.dto.LoginDto;
import ro.dto.MemberDto;
import ro.dto.ProfilePageDto;
import ro.dto.RegisterDto;
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
}
