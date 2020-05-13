package ro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.domain.Conference;
import ro.service.ConferenceService;
import ro.service.MemberService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;


    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/papers", method = RequestMethod.GET)
    public List<Conference> getPapers() {
        return new ArrayList<Conference>(conferenceService.getConferences());
    }

    @RequestMapping(value = "/papers/{username}", method = RequestMethod.GET)
    public List<Conference> getConferencesFromUser(@PathVariable String username){
        return null;
    }
}
