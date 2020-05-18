package ro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.converter.PaperConverter;
import ro.converter.PublishedPaperConverter;
import ro.domain.Abstract;
import ro.domain.Author;
import ro.domain.Conference;
import ro.domain.MyUser;
import ro.dto.AbstractDto;
import ro.dto.PaperDto;
import ro.dto.PublishedPaperDto;
import ro.service.ConferenceService;
import ro.service.MemberService;
import ro.service.PaperService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PaperController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private PublishedPaperConverter publishedPaperConverter;

    @RequestMapping(value = "/papers", method = RequestMethod.GET)
    public List<PublishedPaperDto> getPapers() {
        return new ArrayList<PublishedPaperDto>(this.publishedPaperConverter.convertModelsToDtos(paperService.getPapers()));
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
}
