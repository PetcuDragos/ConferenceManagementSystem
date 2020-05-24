package ro.hardcodedMain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.domain.*;
import ro.service.ConferenceService;
import ro.service.EvaluationService;
import ro.service.MemberService;
import ro.service.PaperService;

@Component
public class Console {

    @Autowired
    private MemberService memberService;
    @Autowired
    private ConferenceService conferenceService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private EvaluationService evaluationService;

    public void runConsole(){

        try{
            MyUser m = memberService.addUser("admin","admin","admin@yahoo.com","Kosmo Polis","Supergeil","www.supergeil.de");
        }
        catch(Exception e){
            System.out.println("error");
        }
        try{
            MyUser user = memberService.getUserFromUsername("admin");
            if(user!=null)
                memberService.addScMember(user.getId());
        }
        catch(Exception e){
            System.out.println("error");
        }
    }
}
