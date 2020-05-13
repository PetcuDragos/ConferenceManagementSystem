package ro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.dto.LoginDto;
import ro.service.MemberService;

@RestController
public class LoginController {
    public static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private MemberService serviceMember;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean addClient(@RequestBody LoginDto loginDto) {
        log.trace("Controller - addClient - {}", loginDto);
        try {
            serviceMember.login(loginDto.getUsername(),loginDto.getPassword());
            log.trace("Controller - login worked saved");
            return true;
        } catch (Exception e) {
            log.trace("Controller - login failed. Error: \n {}", e.toString());
        }
        return false;
    }
}
