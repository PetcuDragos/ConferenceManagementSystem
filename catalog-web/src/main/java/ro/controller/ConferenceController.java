package ro.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.domain.*;
import ro.dto.*;
import ro.service.ConferenceService;
import ro.service.MemberService;
import ro.utils.Message;

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
        List<UserConference> userList = conferenceService.getUserConferences().stream().filter(p -> p.getUser_id().equals(user.getId())).collect(Collectors.toList());
        List<ConferenceDto> conferenceDtoList = new ArrayList<>();
        pcMemberList.forEach(p -> {
            Conference conference = conferenceService.getConferenceFromId(p.getConference_id());
            if (conference != null)
                conferenceDtoList.add(new ConferenceDto("PCMember", conference.getName()));
        });
        cChairList.forEach(p -> {
            Conference conference = conferenceService.getConferenceFromId(p.getConference_id());
            if (conference != null)
                conferenceDtoList.add(new ConferenceDto("Chair", conference.getName()));
        });
        authorList.forEach(p -> {
            Conference conference = conferenceService.getConferenceFromId(p.getConference_id());
            if (conference != null)
                conferenceDtoList.add(new ConferenceDto("Author", conference.getName()));

        });
        userList.forEach(p -> {
            Conference conference = conferenceService.getConferenceFromId(p.getConference_id());
            if (conference != null)
                conferenceDtoList.add(new ConferenceDto("Member", conference.getName()));
        });
        return conferenceDtoList;
    }

    //GLORIOUS way to access users from any id ref
    @RequestMapping(value = "/conferencest", method = RequestMethod.GET)
    public List<ConferenceDescriptionDto> getConferencesWithChairs() {
        List<ConferenceDescriptionDto> conferenceDtoList = new ArrayList<>();
        List<Conference> conferences = conferenceService.getConferences();
        log.trace("size: {}", conferences.size());
        conferences.forEach(c -> {
            if (c.getChair_id() != null && c.getCo_chair_id() != null) {
                MyUser user1 = memberService.getMemberFromId(memberService.getChairFromId(c.getChair_id()).getUser_id());
                MyUser user2 = memberService.getMemberFromId(memberService.getChairFromId(c.getCo_chair_id()).getUser_id());
                if (user1 != null && user2 != null) {
                    log.trace(" controller: {}", user1.getFullName());
                    log.trace(" controller: {}", user2.getFullName());
                    log.trace("controller : {}", c.getName());
                    MyConferenceDto co = new MyConferenceDto(c.getId(), c.getName(), conferenceService.transformSQLDateIntoMyDate(c.getAbstractDeadline()),
                            conferenceService.transformSQLDateIntoMyDate(c.getPaperDeadline()), conferenceService.transformSQLDateIntoMyDate(c.getBidDeadline()),
                            conferenceService.transformSQLDateIntoMyDate(c.getReviewDeadline()), conferenceService.transformSQLDateIntoMyDate(c.getStartingDate()),
                            conferenceService.transformSQLDateIntoMyDate(c.getEndingDate()), c.getChair_id(), c.getCo_chair_id());
                    conferenceDtoList.add(new ConferenceDescriptionDto(c.getName(), co, user1.getFullName(), user2.getFullName()));
                }
            }
        });
        return conferenceDtoList;
    }

    @RequestMapping(value = "/conferencest", method = RequestMethod.POST)
    public String joinConference(@RequestBody JoinConferenceDto joinConferenceDto) {
        log.trace("controllerrrrrr");
        try {
            long userId = this.memberService.getUserFromUsername(joinConferenceDto.getUsername()).getId();
            this.conferenceService.joinConference(userId, joinConferenceDto.getConference_id());
        } catch (Exception e) {
            return e.toString();
        }
        return "success";
    }

    @Transactional
    @RequestMapping(value = "/add_conference", method = RequestMethod.POST)
    public Message<CreateConferenceDto> createConference(@RequestBody CreateConferenceDto createConferenceDto) {
        //todo validation
        MyUser chair_user = this.memberService.getUserFromUsername(createConferenceDto.getChair_username());
        MyUser co_chair_user = this.memberService.getUserFromUsername(createConferenceDto.getCo_chair_username());
        if (chair_user == null)
            return new Message<CreateConferenceDto>(null, "chair username doesnt match with any user");
        if (co_chair_user == null)
            return new Message<CreateConferenceDto>(null, "co_chair username doesnt match with any user");
        CChair chair = memberService.addCChair(chair_user.getId(), null);
        CChair co_chair = memberService.addCChair(co_chair_user.getId(), null);
        Conference createdConference = null;
        try {
            createdConference = conferenceService.addConference(createConferenceDto.getConference_name(), chair.getId(), co_chair.getId(),
                    createConferenceDto.getStarting_date(), createConferenceDto.getEnding_date(), createConferenceDto.getAbstract_deadline(),
                    createConferenceDto.getPaper_deadline(), createConferenceDto.getBidding_deadline(), createConferenceDto.getReview_deadline());
            chair.setConference_id(createdConference.getId());
            co_chair.setConference_id(createdConference.getId());
            memberService.getChairFromId(chair.getId()).setConference_id(createdConference.getId());
            memberService.getChairFromId(co_chair.getId()).setConference_id(createdConference.getId());
        } catch (Exception e) {
            return new Message<CreateConferenceDto>(null, e.toString());
        }
        return new Message<CreateConferenceDto>(createConferenceDto, "conference creation was successful");
    }

    @RequestMapping(value = "/conference", method = RequestMethod.POST)
    public MyConferenceDto getConferenceByName(@RequestBody String conference_name) {
        Conference c = conferenceService.getConferenceFromName(conference_name);
        MyConferenceDto co = new MyConferenceDto(c.getId(), c.getName(), conferenceService.transformSQLDateIntoMyDate(c.getAbstractDeadline()),
                conferenceService.transformSQLDateIntoMyDate(c.getPaperDeadline()), conferenceService.transformSQLDateIntoMyDate(c.getBidDeadline()),
                conferenceService.transformSQLDateIntoMyDate(c.getReviewDeadline()), conferenceService.transformSQLDateIntoMyDate(c.getStartingDate()),
                conferenceService.transformSQLDateIntoMyDate(c.getEndingDate()), c.getChair_id(), c.getCo_chair_id());
        return co;
    }

    @RequestMapping(value = "/ispcmember", method = RequestMethod.POST)
    public boolean isUserPCMemberAtConference(@RequestBody UserRankDto rank) {
        MyUser user = memberService.getUserFromUsername(rank.getUsername());
        Conference conference = conferenceService.getConferenceFromName(rank.getConference_name());
        if (user != null && conference != null) {
            return memberService.getPcMembers().stream().anyMatch(p -> p.getUser_id().equals(user.getId()) && p.getConference_id().equals(conference.getId()));
        }
        return false;
    }

    @RequestMapping(value = "/ischair", method = RequestMethod.POST)
    public boolean isUserChairAtConference(@RequestBody UserRankDto rank) {
        MyUser user = memberService.getUserFromUsername(rank.getUsername());
        Conference conference = conferenceService.getConferenceFromName(rank.getConference_name());
        if (user != null && conference != null) {
            return memberService.getCChairs().stream().anyMatch(p -> p.getUser_id().equals(user.getId()) && p.getConference_id().equals(conference.getId()));
        }
        return false;
    }

    @RequestMapping(value = "/addpcmember", method = RequestMethod.POST)
    public boolean addPCMember(@RequestBody UserRankDto rank) {
        MyUser user = memberService.getUserFromUsername(rank.getUsername());
        Conference conference = conferenceService.getConferenceFromName(rank.getConference_name());
        if (user != null && conference != null) {
            try {
                memberService.addPcMember(conference.getId(), user.getId());
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @RequestMapping(value = "/change_deadline", method = RequestMethod.PUT)
    public Message<ChangeDeadlineDto> changeDeadline(@RequestBody ChangeDeadlineDto changeDeadlineDto) {
        //todo validation
        try {
            log.trace("a ajuns in controller");
            this.conferenceService.changeDeadlines(this.conferenceService
                    .getConferenceFromName(changeDeadlineDto.getConference()).getId(),
                    changeDeadlineDto.getAbstract_deadline(), changeDeadlineDto.getPaper_deadline(),
                    changeDeadlineDto.getBidding_deadline(), changeDeadlineDto.getReview_deadline(),
                    changeDeadlineDto.getEnding_date());
        } catch (Exception e) {
            log.trace("i-o dat eroare la fraier");
            return new Message<ChangeDeadlineDto>(null, e.toString());
        }
        log.trace("gataaaa");
        return new Message<ChangeDeadlineDto>(changeDeadlineDto, "changing deadline was successful");
    }

}
