package ro.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.domain.*;
import ro.dto.ConferenceChairCoChairDto;
import ro.dto.ConferenceDto;
import ro.service.ConferenceService;
import ro.service.MemberService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
public class ConferenceController {

    public static final Logger log = LoggerFactory.getLogger(MemberService.class);
    @Autowired
    private ConferenceService conferenceService;
    @Autowired
    private MemberService memberService;

    public static <T> Collector<T, ?, T> toSingleton() { //Awesome to use in lambdas where u need just one element returned by id
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException();
                    }
                    return list.get(0);
                }
        );
    }

    @RequestMapping(value = "/conferences", method = RequestMethod.GET)
    public List<Conference> getConferences() {
        return new ArrayList<Conference>(conferenceService.getConferences());
    }

    @RequestMapping(value = "/conferences", method = RequestMethod.POST)
    public List<ConferenceDto> getConferencesFromUser(@RequestBody String username) {
        MyUser user = memberService.getUserFromUsername(username);
        List<PcMember> pcMemberList = memberService.getPcMembers().stream().filter(p -> p.getUser_id().equals(user.getId())).collect(Collectors.toList());
        List<CChair> cChairList = memberService.getCChairs().stream().filter(p -> p.getUser_id().equals(user.getId())).collect(Collectors.toList());
        List<Author> authorList = memberService.getAuthors().stream().filter(p -> p.getUser_id().equals(user.getId())).collect(Collectors.toList());
        List<UserConference> userList = conferenceService.getUserConferences().stream().filter(p -> p.getId().equals(user.getId())).collect(Collectors.toList());
        List<ConferenceDto> conferenceDtoList = new ArrayList<>();
        pcMemberList.forEach(p -> {
            Conference conference = conferenceService.getConferenceFromId(p.getConference_id());
            if(conference!=null)
                conferenceDtoList.add(new ConferenceDto("PCMember", conference.getName()));
        });
        cChairList.forEach(p -> {
            Conference conference = conferenceService.getConferenceFromId(p.getConference_id());
            if(conference!=null)
            conferenceDtoList.add(new ConferenceDto("Chair", conference.getName()));
        });
        authorList.forEach(p -> {
            Conference conference = conferenceService.getConferenceFromId(p.getConference_id());
            if(conference!=null)
                conferenceDtoList.add(new ConferenceDto("Author", conference.getName()));

        });
        userList.forEach(p -> {
            Conference conference = conferenceService.getConferenceFromId(p.getConference_id());
            if(conference!=null)
                conferenceDtoList.add(new ConferenceDto("Member", conference.getName()));
        });
        return conferenceDtoList;
    }

    //GLORIOUS way to access users from any id ref
    @RequestMapping(value = "/conferencest", method = RequestMethod.GET)
    public List<ConferenceChairCoChairDto> getConferencesWithChairs() {
        List<ConferenceChairCoChairDto> conferenceDtoList = new ArrayList<>();
        List<Conference> conferences = conferenceService.getConferences();
        log.trace("size: {}",conferences.size());
        conferences.forEach(c -> {
            if (c.getChair_id() != null && c.getCo_chair_id() != null) {
                String name1 = memberService.getMemberFromId(memberService.getChairFromId(c.getChair_id()).getUser_id()).getFullName();
                String name2 = memberService.getMemberFromId(memberService.getChairFromId(c.getCo_chair_id()).getUser_id()).getFullName();
                log.trace(" controller: {}", name1);
                log.trace(" controller: {}", name2);
                log.trace("controller : {}", c.getName());
                conferenceDtoList.add(new ConferenceChairCoChairDto(
                        c.getName(),
                        c,
                        name1,
                        name2
                ));
            }
        });
        return conferenceDtoList;
    }

}
