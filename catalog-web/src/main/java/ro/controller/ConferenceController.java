package ro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.domain.*;
import ro.dto.ConferenceDto;
import ro.service.ConferenceService;
import ro.service.MemberService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;


    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/conferences", method = RequestMethod.GET)
    public List<Conference> getConferences() {
        return new ArrayList<Conference>(conferenceService.getConferences());
    }

    @RequestMapping(value = "/conferences", method = RequestMethod.POST)
    public List<ConferenceDto> getConferencesFromUser(@RequestBody String username){
        MyUser user = memberService.getUserFromUsername(username);
        List<PcMember> pcMemberList = memberService.getPcMembers().stream().filter(p -> p.getUser_id().equals(user.getId())).collect(Collectors.toList());
        List<CChair> cChairList = memberService.getCChairs().stream().filter(p->p.getUser_id().equals(user.getId())).collect(Collectors.toList());
        List<Author> authorList = memberService.getAuthors().stream().filter(p->p.getUser_id().equals(user.getId())).collect(Collectors.toList());
        List<UserConference> userList = conferenceService.getUserConferences().stream().filter(p->p.getId().equals(user.getId())).collect(Collectors.toList());
        List<ConferenceDto> conferenceDtoList = new ArrayList<>();
        pcMemberList.forEach(p->conferenceDtoList.add(new ConferenceDto("PCMember",conferenceService.getConferenceFromId(p.getConference_id()))));
        cChairList.forEach(p->conferenceDtoList.add(new ConferenceDto("Chair",conferenceService.getConferenceFromId(p.getConference_id()))));
        authorList.forEach(p->conferenceDtoList.add(new ConferenceDto("Author",conferenceService.getConferenceFromId(p.getConference_id()))));
        userList.forEach(p->conferenceDtoList.add(new ConferenceDto("Member",conferenceService.getConferenceFromId(p.getConference_id()))));
        return conferenceDtoList;
    }
}
