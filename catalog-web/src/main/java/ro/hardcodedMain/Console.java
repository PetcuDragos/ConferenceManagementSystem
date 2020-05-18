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
/*
        // making users
        try {
            memberService.register("admin", "admin", "admin", "admin@admin.com", "admin", "admin", "www.admin.com");
            memberService.addScMember(memberService.getUserFromUsername("admin").getId());
        }
        catch(Exception e){ }
        try {
            memberService.register("pcmember1", "pcmember1", "pcmember1", "pcmember1@pcmember1.com", "pcmember1", "pcmember1", "www.pcmember1.com");
            memberService.register("pcmember2", "pcmember2", "pcmember2", "pcmember2@pcmember2.com", "pcmember2", "pcmember2", "www.pcmember2.com");
            memberService.register("pcmember3", "pcmember3", "pcmember3", "pcmember3@pcmember3.com", "pcmember3", "pcmember3", "www.pcmember3.com");
            memberService.register("pcmember4", "pcmember4", "pcmember4", "pcmember4@pcmember4.com", "pcmember4", "pcmember4", "www.pcmember4.com");
            memberService.register("pcmember5", "pcmember5", "pcmember5", "pcmember5@pcmember5.com", "pcmember5", "pcmember5", "www.pcmember5.com");
            memberService.register("author1", "author1", "author1", "author1@author1.com", "author1", "author1", "www.author1.com");
            memberService.register("author2", "author2", "author2", "author2@author2.com", "author2", "author2", "www.author2.com");
            memberService.register("chair1", "chair1", "chair1", "chair1@chair1.com", "chair1", "chair1", "www.chair1.com");
            memberService.register("cochair1", "cochair1", "cochair1", "cochair1@cochair1.com", "cochair1", "cochair1", "www.cochair1.com");
        }
        catch(Exception e){ }
        try{
        Conference conference  = conferenceService.addConference("First conference",null,null,new Date(1,2,2020),new Date(1,3,2020),null,null,null,null);

        CChair chair = memberService.addCChair(memberService.getUserFromUsername("chair1").getId(),conference.getId());
        CChair cochair = memberService.addCChair(memberService.getUserFromUsername("cochair1").getId(),conference.getId());
        conferenceService.getConferenceFromName("First conference").setChair_id(chair.getId());
        conferenceService.getConferenceFromName("First conference").setCo_chair_id(cochair.getId());



        memberService.addPcMember(conference.getId(),memberService.getUserFromUsername("pcmember1").getId());
        memberService.addPcMember(conference.getId(),memberService.getUserFromUsername("pcmember2").getId());
        memberService.addPcMember(conference.getId(),memberService.getUserFromUsername("pcmember3").getId());
        Author author1 = memberService.addAuthor(memberService.getUserFromUsername("author1").getId(),conference.getId());
        Author author2 = memberService.addAuthor(memberService.getUserFromUsername("author2").getId(),conference.getId());
        // abstracts
        }
        catch(Exception e){ }
        Abstract abstract1 = paperService.addAbstract("","","Cars","Cost Newman, Richard Morison", "its all about cars," +
                "so what i am saying is, grow up, get a licence or sth and ride until murica even tho thats on water, they gotta have a bridge or sth until there.",memberService.getAuthors().get(0).getId(),conferenceService.getConferenceFromName("First conference").getId());

        Abstract abstract2 = paperService.addAbstract("no car; walk; lifestyle","Travelling","Walking","Petcu Dragos the Second", "" +
                "bad thing is that i forgot how to, but its like riding a bike, how hard can it be? And still i donno how to ride a bike. ",memberService.getAuthors().get(1).getId(),conferenceService.getConferenceFromName("First conference").getId());

        paperService.addPaper(abstract1.getId(),null,"paper1.pdf",conferenceService.getConferenceFromName("First conference").getId(),memberService.getAuthors().get(0).getId());
        paperService.addPaper(abstract2.getId(),null,"paper1.pdf",conferenceService.getConferenceFromName("First conference").getId(),memberService.getAuthors().get(1).getId());

*/
        conferenceService.getConferenceFromId((long) 1).setChair_id((long) 1);
        conferenceService.getConferenceFromId((long) 1).setCo_chair_id((long) 2);
        conferenceService.getConferenceFromId((long) 2).setChair_id((long) 1);
        conferenceService.getConferenceFromId((long) 2).setCo_chair_id((long) 2);

    }
}
