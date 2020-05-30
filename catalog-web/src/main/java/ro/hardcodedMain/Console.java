package ro.hardcodedMain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.domain.MyUser;
import ro.service.ConferenceService;
import ro.service.EvaluationService;
import ro.service.MemberService;
import ro.service.PaperService;

@Component
public class Console {

    @Autowired
    private MemberService memberService;

    public void runConsole() {

        try {
            memberService.addUser("admin", "admin", "admin@yahoo.com", "Kosmo Polis", "Supergeil", "www.supergeil.de");
        } catch (Exception e) {
            System.out.println("error");
        }
        try {
            MyUser user = memberService.getUserFromUsername("admin");
            if (user != null)
                memberService.addScMember(user.getId());
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
