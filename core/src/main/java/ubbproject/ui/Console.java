package ubbproject.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ubbproject.service.ConferenceService;
import ubbproject.service.EvaluationService;
import ubbproject.service.MemberService;
import ubbproject.service.PaperService;

@Component
public class Console {

    @Autowired
    private ConferenceService conferenceService;
    @Autowired
    private EvaluationService evaluationService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private PaperService paperService;

    public Console() {
    }

    public void run(){
        System.out.println("hello");
    }
}
