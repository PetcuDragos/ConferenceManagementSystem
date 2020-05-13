package ro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.repository.*;

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
}
