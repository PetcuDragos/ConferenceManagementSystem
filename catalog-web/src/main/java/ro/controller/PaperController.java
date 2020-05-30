package ro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ro.converter.PaperConverter;
import ro.converter.PublishedPaperConverter;
import ro.domain.*;
import ro.dto.*;
import ro.service.ConferenceService;
import ro.service.EvaluationService;
import ro.service.MemberService;
import ro.service.PaperService;
import ro.utils.Message;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class PaperController {

    public static final Logger log = LoggerFactory.getLogger(PaperController.class);

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

    @Autowired
    private EvaluationService evaluationService;

    @RequestMapping(value = "/papers", method = RequestMethod.GET)
    public List<PaperDto> getPapers() {
        return new ArrayList<>(this.paperConverter.convertModelsToDtos(paperService.getPapers()));
    }

    @RequestMapping(value = "/published-papers", method = RequestMethod.GET)
    public List<PublishedPaperDto> getPublishedPapers() {
        return new ArrayList<>(this.publishedPaperConverter.convertModelsToDtos(paperService.getPublishedPapers()));
    }

    @RequestMapping(value = "/abstract", method = RequestMethod.GET, params = {"conferenceName", "username"})
    public List<AbstractDto> getAbstractsFromConferenceName(@RequestParam("conferenceName") String conferenceName, @RequestParam("username") String username) {
        Conference conference = this.conferenceService.getConferenceFromName(conferenceName);
        if (conference != null) {
            List<AbstractDto> abstracts = new ArrayList<>();
            paperService.getAbstracts().stream().filter(a -> a.getConference_id().equals(conference.getId())).forEach(p -> {
                Author author = memberService.getAuthorById(p.getAuthor_id());
                if (author != null) {
                    MyUser user = memberService.getMemberFromId(author.getUser_id());
                    boolean bidded = false;
                    boolean reviewed = false;
                    boolean canReview = false;
                    try {
                        if (this.evaluationService.getBidEvaluations().stream().anyMatch(c -> c.getAbstract_id().equals(p.getId()) && memberService.getPcMemberFromId(c.getPc_id()).getUser_id().equals(memberService.getUserFromUsername(username).getId())))
                            bidded = true;
                        if (this.evaluationService.getReviewEvaluations().stream().anyMatch(c ->
                                c.getPaper_id().equals(paperService.getPaperFromAbstractId(p.getId()).getId()) && memberService.getPcMemberFromId(c.getPc_id()).getUser_id().equals(memberService.getUserFromUsername(username).getId()) && c.getDate() != null))
                            reviewed = true;
                        if (this.evaluationService.getReviewEvaluations().stream().anyMatch(c ->
                                c.getPaper_id().equals(paperService.getPaperFromAbstractId(p.getId()).getId()) && memberService.getPcMemberFromId(c.getPc_id()).getUser_id().equals(memberService.getUserFromUsername(username).getId())))
                            canReview = true;
                    } catch (Exception e) {
                    }
                    List<String> reviewers = evaluationService.getReviewerNamesForPaper(p.getId());
                    List<Section> sections = this.conferenceService.getSectionsFromConference(conference.getId());
                    List<SectionDto> my_sections = new ArrayList<>();
                    Paper paper = paperService.getPaperFromAbstractId(p.getId());
                    if(paper!= null) {
                        PublishedPaper publishedPaper = paperService.getPublishedPapers().stream().filter(pub -> pub.getPaper_id().equals(paper.getId()) && pub.getSection_id() != null).findFirst().orElse(null);
                        if(publishedPaper==null)
                            sections.forEach(s -> my_sections.add(new SectionDto(s.getName(), memberService.getMemberFromId(s.getUser_id()).getUsername())));
                    }

                    if (conference.getSubmissionDate().before(new java.sql.Date(Calendar.getInstance().getTime().getTime()))) {
                        int review_result = evaluationService.checkPaperStatusReview(conference.getId(), p.getId());
                        if (review_result == 1) {
                            paperService.addPublishedPaper(p.getId(), null, user);
                        }
                        PublishedPaper publishedPaper = paperService.getPublishedPapers().stream().filter(pp -> pp.getPaper_id().equals(p.getId())).findAny().orElse(null);
                        if (publishedPaper != null)
                            abstracts.add(new AbstractDto(p.getId(), p, user.getUsername(), bidded, reviewed, paperService.getUrl(p.getId()), canReview, reviewers, my_sections));
                    } else if (conference.getReEvalDate().before(new java.sql.Date(Calendar.getInstance().getTime().getTime()))) {
                        int review_result = evaluationService.checkPaperStatusReReview(conference.getId(), p.getId());
                        if (review_result == 1) {
                            paperService.addPublishedPaper(p.getId(), null, user);
                        } else if (review_result == 0)
                            abstracts.add(new AbstractDto(p.getId(),p, user.getUsername(), bidded, reviewed, paperService.getUrl(p.getId()), canReview, reviewers, my_sections));
                    } else if (conference.getReviewDeadline().before(new java.sql.Date(Calendar.getInstance().getTime().getTime()))) {
                        int review_result = evaluationService.checkPaperStatusReview(conference.getId(), p.getId());
                        if (review_result == 1) {
                            paperService.addPublishedPaper(p.getId(), null, user);
                        }
                        if (review_result == 0)
                            abstracts.add(new AbstractDto(p.getId(),p, user.getUsername(), bidded, reviewed, paperService.getUrl(p.getId()), canReview, reviewers, my_sections));
                    } else if (conference.getBidDeadline().before(new java.sql.Date(Calendar.getInstance().getTime().getTime()))) {
                        int bid_result = evaluationService.checkPaperStatusBidding(conference.getId(), p.getId());
                        if (bid_result == 0)
                            abstracts.add(new AbstractDto(p.getId(),p, user.getUsername(), bidded, reviewed, paperService.getUrl(p.getId()), canReview, reviewers, my_sections));
                    } else if (conference.getPaperDeadline().before(new java.sql.Date(Calendar.getInstance().getTime().getTime()))) {
                        int callforpaper_result = evaluationService.checkPaperStatusCallForPaper(p.getId());
                        if (callforpaper_result == 0)
                            abstracts.add(new AbstractDto(p.getId(),p, user.getUsername(), bidded, reviewed, paperService.getUrl(p.getId()), canReview, reviewers, my_sections));
                    } else
                        abstracts.add(new AbstractDto(p.getId(),p, user.getUsername(), bidded, reviewed, paperService.getUrl(p.getId()), canReview, reviewers, my_sections));


                }
            });
            return abstracts;
        }
        return null;

    }

    @RequestMapping(value = "/createabstract", method = RequestMethod.POST)
    public Message<String> addAbstract(@RequestBody CreateAbstractDto abstractDto) {
        MyUser user = memberService.getUserFromUsername(abstractDto.getUsername());
        Conference conference = conferenceService.getConferenceFromName(abstractDto.getConference_name());
        if (user != null && conference != null) {
            Author author = this.memberService.addAuthor(user.getId(), conference.getId());
            try {
                Abstract a = this.paperService.addAbstract(abstractDto.getKeywords(), abstractDto.getTopics(), abstractDto.getTitle(), abstractDto.getAdditional_authors(), abstractDto.getContent(), author.getId(), conference.getId());
                if (abstractDto.getUrl() != null) {
                    paperService.addPaper(a.getId(), abstractDto.getUrl(), conference.getId(), author.getId());
                }
                return new Message<>(null, "success");
            } catch (Exception e) {
                return new Message<>(null, "error");
            }
        }
        return new Message<>(null, "error");
    }

    @Transactional
    @RequestMapping(value = "/editabstract", method = RequestMethod.POST)
    public Message<String> editAbstract(@RequestBody CreateAbstractDto abstractDto) {
        MyUser user = memberService.getUserFromUsername(abstractDto.getUsername());
        Conference conference = conferenceService.getConferenceFromName(abstractDto.getConference_name());
        if (user != null && conference != null) {
            try {
                Abstract abs = paperService.getAbstracts().stream().filter(a -> memberService.getAuthorById(a.getAuthor_id()).getUser_id().equals(user.getId()) && a.getConference_id().equals(conference.getId())).findFirst().orElse(null);
                if (abs != null) {
                    Abstract abstract_change = paperService.getAbstractById(abs.getId());
                    abstract_change.setContent(abstractDto.getContent());
                    abstract_change.setAdditionalAuthors(abstractDto.getAdditional_authors());
                    abstract_change.setKeywords(abstractDto.getKeywords());
                    abstract_change.setName(abstractDto.getTitle());
                    abstract_change.setTopics(abstractDto.getTopics());


                    if (abstractDto.getUrl() != null) {
                        Paper paper = paperService.getPaperFromAbstractId(abs.getId());
                        if (paper == null)
                            paperService.addPaper(abs.getId(), abstractDto.getUrl(), conference.getId(), abs.getAuthor_id());
                        else paper.setDocument(abstractDto.getUrl());
                    }

                    return new Message<>(null, "success");
                }
            } catch (Exception e) {
                return new Message<>(null, "error");
            }
        }
        return new Message<>(null, "error");
    }

    @RequestMapping(value = "/getabstract", method = RequestMethod.GET, params = {"username", "conference"})
    public CreateAbstractDto getAbstract(@RequestParam("username") String username, @RequestParam("conference") String conferenceName) {
        MyUser user = memberService.getUserFromUsername(username);
        Conference conference = conferenceService.getConferenceFromName(conferenceName);
        if (user != null && conference != null) {
            try {
                Abstract abs = paperService.getAbstracts().stream().filter(a -> memberService.getAuthorById(a.getAuthor_id()).getUser_id().equals(user.getId()) && a.getConference_id().equals(conference.getId())).findFirst().orElse(null);
                if (abs != null) {

                    return new CreateAbstractDto(username, conferenceName, abs.getName(), abs.getContent(), abs.getKeywords(), abs.getTopics(), abs.getAdditionalAuthors(), (long) 0, "");
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @RequestMapping(value = "/createbid", method = RequestMethod.POST)
    public Message<String> addBid(@RequestBody CreateBidDto bidDto) {

        log.trace("pana AICI");
        try {
            MyUser userId = memberService.getUserFromUsername(bidDto.getPc_name());
            PcMember pcMember = memberService.getPcMembers().stream().filter(p -> p.getUser_id().equals(userId.getId())).findAny().orElse(null);
            if (pcMember != null) {
                Conference conference = conferenceService.getConferenceFromId(pcMember.getConference_id());

                Abstract abstrac = paperService.getAbstracts().stream().filter(a -> a.getId().equals(bidDto.getAbstract_id())).findAny().orElse(null);
                if (abstrac != null) {
                    if (conference != null && evaluationService.getBidEvaluations().stream().noneMatch(b -> b.getAbstract_id().equals(bidDto.getAbstract_id()) && b.getPc_id().equals(pcMember.getId()))) {
                        this.evaluationService.addBid(pcMember.getId(), bidDto.getAbstract_id(), bidDto.getResult(), bidDto.getDate());
                        return new Message<>(null, "success");
                    }
                }
            }
        } catch (Exception e) {
            return new Message<>(null, "error");
        }
        return new Message<>(null, "error");
    }

    @RequestMapping(value = "/download_paper", method = RequestMethod.GET, params = {"abstract_url"})
    @ResponseBody
    public FileSystemResource getFile(@RequestParam("abstract_url") String fileName) {
        File f = new File("/resources/" + fileName);
        return new FileSystemResource(f);
    }

    @RequestMapping(value = "/addpublishedpaper", method = RequestMethod.POST)
    public Message<String> addPublishedPaper(@RequestBody AddPublishedPaperDto publishedPaperDto) {
        Paper p = paperService.getPaperFromAbstractId(publishedPaperDto.getAbstract_id());
        Author author = memberService.getAuthorById(publishedPaperDto.getAuthor_id());
        if (p != null && author != null) {
            MyUser u = memberService.getMemberFromId(author.getUser_id());
            this.paperService.addPublishedPaper(p.getId(), null, u);
            return new Message<>(null, "success");
        }
        return new Message<>(null, "error");
    }

}
