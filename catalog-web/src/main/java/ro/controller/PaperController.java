package ro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.converter.PaperConverter;
import ro.converter.PublishedPaperConverter;
import ro.domain.Author;
import ro.domain.Conference;
import ro.domain.MyUser;
import ro.domain.PublishedPaper;
import ro.dto.*;
import ro.service.ConferenceService;
import ro.service.MemberService;
import ro.service.PaperService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PaperController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private PaperConverter paperConverter;

    @Autowired
    private PublishedPaperConverter publishedPaperConverter;

    @RequestMapping(value = "/papers", method = RequestMethod.GET)
    public List<PaperDto> getPapers() {
        return new ArrayList<PaperDto>(this.paperConverter.convertModelsToDtos(paperService.getPapers()));
    }

    @RequestMapping(value = "/published-papers", method = RequestMethod.GET)
    public List<PublishedPaperDto> getPublishedPapers() {
        return new ArrayList<PublishedPaperDto>(this.publishedPaperConverter.convertModelsToDtos(paperService.getPublishedPapers()));
    }

    @RequestMapping(value = "/abstract", method = RequestMethod.GET, params = {"conferenceName"})
    public List<AbstractDto> getAbstractsFromConferenceName(@RequestParam("conferenceName") String conferenceName) {
        Conference conference= this.conferenceService.getConferenceFromName(conferenceName);
        if(conference!=null){
            List<AbstractDto> abstracts = new ArrayList<>();
            paperService.getAbstracts().stream().filter(a->a.getConference_id()==conference.getId()).forEach(p->{
                Author author = memberService.getAuthorById(p.getAuthor_id());
                if(author!= null) {
                    MyUser user = memberService.getMemberFromId(author.getUser_id());
                    abstracts.add(new AbstractDto(p,user.getFullName()));
                }
            });
            return abstracts;
        }
        return null;

    }

    @RequestMapping(value = "/createabstract", method = RequestMethod.POST)
    public String addAbstract(@RequestBody CreateAbstractDto abstractDto) {
        MyUser user = memberService.getUserFromUsername(abstractDto.getUsername());
        Conference conference = conferenceService.getConferenceFromName(abstractDto.getConference_name());
        if (user!=null && conference!=null){
            Author author = this.memberService.addAuthor(user.getId(),conference.getId());
            try{
                this.paperService.addAbstract(abstractDto.getKeywords(),abstractDto.getTopics(),abstractDto.getTitle(),abstractDto.getAdditional_authors(),abstractDto.getContent(),author.getId(),conference.getId());
                return "success";
            }
            catch(Exception e){
                return e.toString();
            }
        }
        return "error";
    }
}
