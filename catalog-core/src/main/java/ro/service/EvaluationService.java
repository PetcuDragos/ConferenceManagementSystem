package ro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.domain.*;
import ro.repository.*;

import java.util.List;

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

    public EvaluationService() {
    }

    public List<Conference> getConferences(){return this.conferenceRepository.findAll();}

    public List<Paper> getPapers(){return this.paperRepository.findAll();}

    public List<ReviewEvaluation> getReviewEvaluations(){return this.reviewEvaluationRepository.findAll();}

    public List<BidEvaluation> getBidEvaluations(){return this.bidEvaluationRepository.findAll();}

    public List<CChair> getCChairs(){return this.cChairRepository.findAll();}

    public List<PcMember> getPcMembers(){return this.pcMemberRepository.findAll();}
}
