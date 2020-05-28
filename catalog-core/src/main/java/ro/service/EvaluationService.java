package ro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.domain.*;
import ro.repository.*;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EvaluationService {

    @Autowired
    private ConferenceRepository conferenceRepository;
    @Autowired
    private PaperRepository paperRepository;
    @Autowired
    private ReviewEvaluationRepository reviewEvaluationRepository;
    @Autowired
    private BidEvaluationRepository bidEvaluationRepository;
    @Autowired
    private CChairRepository cChairRepository;
    @Autowired
    private PcMemberRepository pcMemberRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublishedPaperRepository publishedPaperRepository;
    @Autowired
    private MyUserRepository myUserRepository;

    public EvaluationService() {
    }

    public List<Conference> getConferences() {
        return this.conferenceRepository.findAll();
    }

    public List<Paper> getPapers() {
        return this.paperRepository.findAll();
    }

    public List<ReviewEvaluation> getReviewEvaluations() {
        return this.reviewEvaluationRepository.findAll();
    }

    public List<BidEvaluation> getBidEvaluations() {
        return this.bidEvaluationRepository.findAll();
    }

    public List<CChair> getCChairs() {
        return this.cChairRepository.findAll();
    }

    public List<PcMember> getPcMembers() {
        return this.pcMemberRepository.findAll();
    }

    public java.sql.Date transformMyDateIntoSQLDate(Date myDate) {
        return java.sql.Date.valueOf(myDate.getYear().toString() + '-' + myDate.getMonth().toString() + '-' + myDate.getDay().toString());
    }

    public BidEvaluation addBid(Long pc_id, Long abs_id, Integer result, Date date) {
        return this.bidEvaluationRepository.save(new BidEvaluation(pc_id, abs_id, result, transformMyDateIntoSQLDate(date)));
    }

    public ReviewEvaluation addReview(Long pc_id, Long paper_id) {
        return this.reviewEvaluationRepository.save(new ReviewEvaluation(pc_id, paper_id, 0, null, null));
    }

    @Transactional
    public ReviewEvaluation updateReview(Long pc_id, Long paper_id, Integer result, Date date, String content) {
        ReviewEvaluation r = this.reviewEvaluationRepository.findAll().stream().filter(p -> p.getPc_id().equals(pc_id) && p.getPaper_id().equals(paper_id)).findFirst().orElse(null);
        if (r != null) {
            r.setResult(result);
            r.setContent(content);
            r.setDate(transformMyDateIntoSQLDate(date));
            return r;
        }
        return null;
    }

    public Author getAuthorById(Long author_id) {
        return authorRepository.findById(author_id).orElse(null);
    }


    public List<PcMember> getPCMembersAvailableForPaper(Long conference_id, Paper p) {
        Author a = getAuthorById(p.getAuthor_id());
        List<PcMember> pc_members = new ArrayList<>();
        if (a == null) return pc_members;
        List<BidEvaluation> bids = this.bidEvaluationRepository.findAll();
        List<ReviewEvaluation> rev = this.reviewEvaluationRepository.findAll();
        if (rev.stream().filter(r -> r.getPaper_id().equals(p.getId())).count() >= 4) return pc_members;
        this.pcMemberRepository.findAll().forEach(pc -> {
            if (pc.getConference_id().equals(conference_id) && !pc.getMyuser_id().equals(a.getMyuser_id())) {
                BidEvaluation bid = bids.stream().filter(b -> b.getPc_id().equals(pc.getId()) && b.getAbstract_id().equals(p.getAbstract_id())).findFirst().orElse(null);
                ReviewEvaluation rew = rev.stream().filter(r -> r.getPc_id().equals(pc.getId()) && r.getPaper_id().equals(p.getId())).findAny().orElse(null);
                if (rew == null) {
                    if (bid == null) pc_members.add(pc);
                    else if (bid.getResult() >= 0) {
                        pc_members.add(pc);
                    }
                }
            }
        });
        return pc_members;
    }

    public List<PcMember> getPossibleReviewersForPaper(Long conference_id, Paper p) {
        Author a = getAuthorById(p.getAuthor_id());
        List<PcMember> pc_members = new ArrayList<>();
        if (a == null) return pc_members;
        List<BidEvaluation> bids = this.bidEvaluationRepository.findAll();
        this.pcMemberRepository.findAll().forEach(pc -> {
            if (pc.getConference_id().equals(conference_id) && !pc.getMyuser_id().equals(a.getMyuser_id())) {
                BidEvaluation bid = bids.stream().filter(b -> b.getPc_id().equals(pc.getId()) && b.getAbstract_id().equals(p.getAbstract_id())).findFirst().orElse(null);
                if (bid == null) pc_members.add(pc);
                else if (bid.getResult() >= 0) {
                    pc_members.add(pc);
                }
            }
        });
        return pc_members;
    }


    public List<ReviewEvaluation> getEvaluationsForPaper(Long paper_id) {
        return this.reviewEvaluationRepository.findAll().stream().filter(p -> p.getPaper_id().equals(paper_id)).collect(Collectors.toList());
    }

    public Paper getPaperFromAbstractId(Long abstract_id) {
        return this.paperRepository.findAll().stream().filter(p -> p.getAbstract_id().equals(abstract_id)).findAny().orElse(null);
    }


    public int checkPaperStatusReview(Long conference_id,Long abstract_id) {
        if(checkPaperStatusBidding(conference_id,abstract_id) == -1) return -1;
        Paper p = getPaperFromAbstractId(abstract_id);
        PublishedPaper publishedPaper = publishedPaperRepository.findAll().stream().filter(pp -> pp.getPaper_id().equals(p.getId())).findAny().orElse(null);
        if(publishedPaper!= null) return -1;
        int minim = 0;
        int maxim = 0;
        List<ReviewEvaluation> evaluationsForPaper = getEvaluationsForPaper(p.getId());
        for(ReviewEvaluation r: evaluationsForPaper){
            if(r.getResult()<minim) minim = r.getResult();
            if(r.getResult()>maxim) maxim = r.getResult();
        }
        if(minim == maxim && minim == 0) return 0;
        if (minim >= 0) return 1;
        if (maxim <= 0) return -1;
        return 0;
    }

    public int checkPaperStatusBidding(Long conference_id, Long abstract_id) {
        if (checkPaperStatusCallForPaper(abstract_id) == -1) return -1;
        Paper p = this.getPaperFromAbstractId(abstract_id);
        if (getPossibleReviewersForPaper(conference_id, p).size() < 2) return -1;
        return 0;
    }

    public int checkPaperStatusCallForPaper(Long abstract_id) {
        Paper p = this.getPaperFromAbstractId(abstract_id);
        if (p == null || p.getDocument() == null) {
            return -1;
        }
        return 0;
    }

    public List<String> getReviewerNamesForPaper(Long abstract_id){
        List<String> reviewers = new ArrayList<>();
        Paper paper = getPaperFromAbstractId(abstract_id);
        if(paper==null) return reviewers;
        reviewEvaluationRepository.findAll().stream().filter(r->r.getPaper_id().equals(paper.getId())).forEach(p->{
            PcMember pc = pcMemberRepository.findById(p.getPc_id()).orElse(null);
            if(pc!=null) {
                MyUser user = myUserRepository.findById(pc.getMyuser_id()).orElse(null);
                if(user!= null ) reviewers.add(user.getUsername());
            }
        });
        return reviewers;
    }

    @Transactional
    public void reEvaluate(Long abstract_id) {
        Paper p = getPaperFromAbstractId(abstract_id);
        if(p!=null){
            p.setReEvaluated(1);
            getEvaluationsForPaper(p.getId()).forEach(ev->{
                ev.setDate(null);
            });
        }
    }

    public void acceptPaper(Long abstract_id) {
        Paper p = getPaperFromAbstractId(abstract_id);
        if(p!=null){
            Author a = getAuthorById(p.getAuthor_id());
            if(a!=null) {
                MyUser u = myUserRepository.findById(a.getMyuser_id()).orElse(null);
                if(u!=null){
                    publishedPaperRepository.save(new PublishedPaper(p.getId(), null));
                    try {
                        MemberService.sendMailPaperAccepted(u.getEmail(),u.getFullName());
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    @Transactional
    public void declinePaper(Long abstract_id) {
        Paper paper = getPaperFromAbstractId(abstract_id);
        if(paper!=null){
            paper.setDocument(null);
        }
    }

    public int checkPaperStatusReReview(Long conference_id,Long abstract_id) {
        Paper p = getPaperFromAbstractId(abstract_id);

        if(p!=null){
            if(p.getReEvaluated()==1) {
                return checkPaperStatusReview(conference_id,abstract_id);
            }
        }
        return -1;
    }
}
