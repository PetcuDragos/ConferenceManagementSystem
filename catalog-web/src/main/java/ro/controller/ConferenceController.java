package ro.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.domain.*;
import ro.dto.*;
import ro.service.ConferenceService;
import ro.service.EvaluationService;
import ro.service.MemberService;
import ro.service.PaperService;
import ro.utils.Message;

import java.io.IOException;
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
    @Autowired
    private EvaluationService evaluationService;
    @Autowired
    private PaperService paperService;

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
    public List<MyConferenceDto> getConferences() {
        List<MyConferenceDto> conferences = new ArrayList<>();
        conferenceService.getConferences().forEach(c -> {
            conferences.add(new MyConferenceDto(c.getId(), c.getName(), conferenceService.transformSQLDateIntoMyDate(c.getAbstractDeadline()),
                    conferenceService.transformSQLDateIntoMyDate(c.getPaperDeadline()), conferenceService.transformSQLDateIntoMyDate(c.getBidDeadline()),
                    conferenceService.transformSQLDateIntoMyDate(c.getReviewDeadline()), conferenceService.transformSQLDateIntoMyDate(c.getStartingDate()),
                    conferenceService.transformSQLDateIntoMyDate(c.getEndingDate()),conferenceService.transformSQLDateIntoMyDate(c.getReEvalDate()),
                    conferenceService.transformSQLDateIntoMyDate(c.getSubmissionDate()),
                    c.getChair_id(), c.getCo_chair_id(),
                    memberService.getPcMembers().stream().filter(p -> p.getConference_id().equals(c.getId())).map(pi -> memberService.getMemberFromId(pi.getUser_id()).getUsername()).collect(Collectors.toList()),
                    conferenceService.getSectionsFromConference(c.getId()).stream().map(s->new SectionDto(s.getName(),memberService.getMemberFromId(s.getUser_id()).getUsername())).collect(Collectors.toList())
                    ));
        });
        return conferences;
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
    @RequestMapping(value = "/conferencest", method = RequestMethod.GET, params = {"username"})
    public List<ConferenceDescriptionDto> getConferencesWithChairs(@RequestParam("username") String username) {
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
                            conferenceService.transformSQLDateIntoMyDate(c.getEndingDate()),conferenceService.transformSQLDateIntoMyDate(c.getReEvalDate()),
                            conferenceService.transformSQLDateIntoMyDate(c.getSubmissionDate()),

                            c.getChair_id(), c.getCo_chair_id(),
                            memberService.getPcMembers().stream().filter(p -> p.getConference_id().equals(c.getId())).map(pi -> memberService.getMemberFromId(pi.getUser_id()).getUsername()).collect(Collectors.toList()),
                            conferenceService.getSectionsFromConference(c.getId()).stream().map(s->new SectionDto(s.getName(),memberService.getMemberFromId(s.getUser_id()).getUsername())).collect(Collectors.toList())
                            );
                    if(username == null || username.equals(""))
                        conferenceDtoList.add(new ConferenceDescriptionDto(c.getName(), co, user1.getFullName(), user2.getFullName(),false));
                    else{
                        if(getConferencesFromUser(username).stream().anyMatch(p -> p.getConferenceName().equals(c.getName())))
                            conferenceDtoList.add(new ConferenceDescriptionDto(c.getName(), co, user1.getFullName(), user2.getFullName(),true));
                        else
                            conferenceDtoList.add(new ConferenceDescriptionDto(c.getName(), co, user1.getFullName(), user2.getFullName(),false));
                    }

                }
            }
        });
        return conferenceDtoList;
    }

    @RequestMapping(value = "/conferencest", method = RequestMethod.POST)
    public Message<String> joinConference(@RequestBody JoinConferenceDto joinConferenceDto) {
        try {
            long userId = this.memberService.getUserFromUsername(joinConferenceDto.getUsername()).getId();
            this.conferenceService.joinConference(userId, joinConferenceDto.getConference_id());
        } catch (Exception e) {
            return new Message<>(null, "error");
        }
        return new Message<>(null, "success");
    }

    @Transactional
    @RequestMapping(value = "/add_conference", method = RequestMethod.POST)
    public Message<CreateConferenceDto> createConference(@RequestBody CreateConferenceDto createConferenceDto) {
        //todo validation
        MyUser chair_user = this.memberService.getUserFromUsername(createConferenceDto.getChair_username());
        MyUser co_chair_user = this.memberService.getUserFromUsername(createConferenceDto.getCo_chair_username());
        if (chair_user == null)
            return new Message<>(null, "chair username doesnt match with any user");
        if (co_chair_user == null)
            return new Message<>(null, "co_chair username doesnt match with any user");
        CChair chair = memberService.addCChair(chair_user.getId(), null);
        CChair co_chair = memberService.addCChair(co_chair_user.getId(), null);
        Conference createdConference = null;
        try {
            createdConference = conferenceService.addConference(createConferenceDto.getConference_name(), chair.getId(), co_chair.getId(),
                    createConferenceDto.getStarting_date(), createConferenceDto.getEnding_date(), createConferenceDto.getAbstract_deadline(),
                    createConferenceDto.getPaper_deadline(), createConferenceDto.getBidding_deadline(), createConferenceDto.getReview_deadline(),createConferenceDto.getReEval_deadline(),createConferenceDto.getSubmissionDate());
            chair.setConference_id(createdConference.getId());
            co_chair.setConference_id(createdConference.getId());
            memberService.getChairFromId(chair.getId()).setConference_id(createdConference.getId());
            memberService.getChairFromId(co_chair.getId()).setConference_id(createdConference.getId());
        } catch (Exception e) {
            return new Message<>(null, e.toString());
        }
        return new Message<>(createConferenceDto, "conference creation was successful");
    }

    @RequestMapping(value = "/conference", method = RequestMethod.POST)
    public MyConferenceDto getConferenceByName(@RequestBody String conference_name) {
        Conference c = conferenceService.getConferenceFromName(conference_name);
        MyConferenceDto co = new MyConferenceDto(c.getId(), c.getName(), conferenceService.transformSQLDateIntoMyDate(c.getAbstractDeadline()),
                conferenceService.transformSQLDateIntoMyDate(c.getPaperDeadline()), conferenceService.transformSQLDateIntoMyDate(c.getBidDeadline()),
                conferenceService.transformSQLDateIntoMyDate(c.getReviewDeadline()), conferenceService.transformSQLDateIntoMyDate(c.getStartingDate()),
                conferenceService.transformSQLDateIntoMyDate(c.getEndingDate()),conferenceService.transformSQLDateIntoMyDate(c.getReEvalDate()),
                conferenceService.transformSQLDateIntoMyDate(c.getSubmissionDate()), c.getChair_id(), c.getCo_chair_id(),
                memberService.getPcMembers().stream().filter(p -> p.getConference_id().equals(c.getId())).map(pi -> memberService.getMemberFromId(pi.getUser_id()).getUsername()).collect(Collectors.toList()),
                conferenceService.getSectionsFromConference(c.getId()).stream().map(s->new SectionDto(s.getName(),memberService.getMemberFromId(s.getUser_id()).getUsername())).collect(Collectors.toList()));
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

    // TODO: A
    @RequestMapping(value = "/isauthor", method = RequestMethod.POST)
    public boolean isUserAuthorOfPaper(@RequestBody UserRankDto rank) {
        Long userId = memberService.getUserFromUsername(rank.getUsername()).getId();
        Long conferenceId = conferenceService.getConferenceFromName(rank.getConference_name()).getId();

        Author author = conferenceService.getAuthor(conferenceId, userId);
        return !(author == null);
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
        try {
            log.trace("a ajuns in controller");
            this.conferenceService.changeDeadlines(this.conferenceService
                            .getConferenceFromName(changeDeadlineDto.getConference()).getId(),
                    changeDeadlineDto.getAbstract_deadline(), changeDeadlineDto.getPaper_deadline(),
                    changeDeadlineDto.getBidding_deadline(), changeDeadlineDto.getReview_deadline(),
                    changeDeadlineDto.getEnding_date(),changeDeadlineDto.getReEval_date(),changeDeadlineDto.getSubmissionDate());
        } catch (Exception e) {
            log.trace("i-o dat eroare la fraier");
            return new Message<ChangeDeadlineDto>(null, e.toString());
        }
        log.trace("gataaaa");
        return new Message<ChangeDeadlineDto>(changeDeadlineDto, "changing deadline was successful");
    }

    @RequestMapping(value = "/updatereview", method = RequestMethod.POST)
    public Message<String> updateReview(@RequestBody ReviewEvaluationDto review) {
        MyUser user = memberService.getUserFromUsername(review.getUsername());
        if (user == null) return new Message<String>(null, "error");
        Long user_id = user.getId();
        Conference c = conferenceService.getConferenceFromName(review.getConference_name());
        if (c == null) return new Message<String>(null, "error");
        PcMember pc = memberService.getPcMembers().stream().filter(p -> p.getUser_id().equals(user_id) && p.getConference_id().equals(c.getId())).findFirst().orElse(null);
        if (pc == null) return new Message<String>(null, "error");
        Paper paper = this.paperService.getPaperFromAbstractId(review.getAbstract_id());
        if (paper == null) return new Message<String>(null, "error");
        try {
            this.evaluationService.updateReview(pc.getId(), paper.getId(), review.getResult(), review.getDate(), review.getContent());
            return new Message<String>(null, "success");
        } catch (Exception e) {

        }

        return new Message<>(null, "error");
    }


    @RequestMapping(value = "/get_reviews", method = RequestMethod.GET, params = {"abstract_id"})
    public List<ReviewDto> getAbstractsFromConferenceName(@RequestParam("abstract_id") Long abstract_id) {
        List<ReviewDto> reviews = new ArrayList<>();
        Paper paper = this.paperService.getPaperFromAbstractId(abstract_id);
        evaluationService.getReviewEvaluations().forEach(r -> {
            if (r.getPaper_id().equals(paper.getId()))
                reviews.add(new ReviewDto(memberService.getMemberFromId(memberService.getPcMemberFromId(r.getPc_id()).getUser_id()).getUsername(), r.getContent(), r.getResult()));
        });
        return reviews;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Message<String> uploadFile(@RequestParam("uploadFile") MultipartFile file, @RequestParam("url") String url) {

        try {
            file.transferTo(paperService.addFile(url));
        } catch (IOException e) {
            return new Message<>(null, "error");
        }
        return new Message<>(null, "success");
    }

    @RequestMapping(value = "/get_reviewers", method = RequestMethod.POST)
    public List<PCMemberDto> getPCMembersAvailableForAbstract(@RequestBody Get_ReviewersDto reviewersDto) {
        Conference c = this.conferenceService.getConferenceFromName(reviewersDto.getConference_name());
        Paper p = this.paperService.getPaperFromAbstractId(reviewersDto.getAbstract_id());
        List<PCMemberDto> pcMembers = new ArrayList<>();
        if (c == null || p == null) return pcMembers;
        List<PcMember> pc = this.evaluationService.getPCMembersAvailableForPaper(c.getId(), p);
        pc.forEach(a -> pcMembers.add(new PCMemberDto(memberService.getMemberFromId(a.getUser_id()).getUsername(), a.getId())));
        return pcMembers;
    }

    @RequestMapping(value = "/addreviewer", method = RequestMethod.POST)
    public Message<String> addReview(@RequestBody Add_ReviewerDto addReviewerDto) {
        PcMember pc = memberService.getPcMemberFromId(addReviewerDto.getPc_id());
        if (pc == null) return new Message<>(null, "error");
        Paper paper = this.paperService.getPaperFromAbstractId(addReviewerDto.getAbstract_id());
        if (paper == null) return new Message<>(null, "error");
        try {
            this.evaluationService.addReview(pc.getId(), paper.getId());
            return new Message<>(null, "success");
        } catch (Exception e) { }
        return new Message<>(null,"error");
    }

    //todo:add to web
    @RequestMapping(value = "/addsection", method = RequestMethod.POST)
    public Message<String> addSection(@RequestBody AddSectionDto addSectionDto){
        Conference c = conferenceService.getConferenceFromName(addSectionDto.getConference_name());
        if(c == null) return new Message<>(null,"error");
        Section s = this.conferenceService.addSection(c.getId(), addSectionDto.getPc_username(), addSectionDto.getSection_name());
        if(s==null) return new Message<>(null,"error");
        return new Message<>(null,"success");
    }

    @RequestMapping(value = "/joinsectionpaper", method = RequestMethod.POST)
    public Message<String> joinSectionPaper(@RequestBody JoinSectionPaperDto joinSectionPaperDto){
        Conference c = conferenceService.getConferenceFromName(joinSectionPaperDto.getConference_name());
        if(c == null) return new Message<>(null,"error");
        MyUser u = memberService.getUserFromUsername(joinSectionPaperDto.getUsername());
        Section section = this.conferenceService.getSections().stream().filter(s->s.getName().equals(joinSectionPaperDto.getSection_name())&&s.getConference_id().equals(c.getId()) && !s.getUser_id().equals(u.getId())).findAny().orElse(null);
        if(section == null) return new Message<>(null,"error");
        Paper p = paperService.getPaperFromAbstractId(joinSectionPaperDto.getAbstract_id());
        if(p == null) return new Message<>(null,"error");
        paperService.updatePublishedPaperSection(p.getId(),section.getId());
        return new Message<>(null,"success");
    }

    @RequestMapping(value = "/askforreeval", method = RequestMethod.POST)
    public Message<String> askForReEval(@RequestBody Long abstract_id){
        this.evaluationService.reEvaluate(abstract_id);
        return new Message<>(null,"success");
    }

    @RequestMapping(value = "/acceptpaper", method = RequestMethod.POST)
    public Message<String> acceptPaper(@RequestBody Long abstract_id){
        this.evaluationService.acceptPaper(abstract_id);
        return new Message<>(null,"success");
    }

    @RequestMapping(value = "/declinepaper", method = RequestMethod.POST)
    public Message<String> declinePaper(@RequestBody Long abstract_id){
        this.evaluationService.declinePaper(abstract_id);
        return new Message<>(null,"success");
    }





}
