package ro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.domain.CChair;
import ro.domain.Conference;
import ro.domain.Date;
import ro.domain.Section;
import ro.repository.*;

import java.util.List;


@Component
public class ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private CChairRepository cChairRepository;
    @Autowired
    private PcMemberRepository pcMemberRepository;

    @Autowired
    private UserConferenceRepository userConferenceRepository;

    public ConferenceService() {
    }

    public List<Conference> getConferences(){return this.conferenceRepository.findAll();}

    public List<Section> getSections(){return this.sectionRepository.findAll();}

    public List<CChair> getCChairs(){return this.cChairRepository.findAll();}

    public boolean isConferenceChair(Long conferenceId, Long userId) {
        //toDo: check if the conference exists
        Conference conference = this.conferenceRepository.getOne(conferenceId);
        return this.pcMemberRepository.findById(this.cChairRepository.findById(conference.getChair_id())
                .get().getPc_id()).get().getUser_id().equals(userId);
    }

    public boolean isConferenceCoChair(Long conferenceId, Long userId) {
        //toDo: check if the conference exists
        Conference conference = this.conferenceRepository.getOne(conferenceId);
        return this.pcMemberRepository.findById(this.cChairRepository.findById(conference.getCo_chair_id())
                .get().getPc_id()).get().getUser_id().equals(userId);
    }

    public void changePaperDeadline(Long conferenceId, Long userId, Date date){
        //toDo: check if the conference exists
        if (isConferenceChair(conferenceId, userId) || isConferenceCoChair(conferenceId, userId))
            this.conferenceRepository.getOne(conferenceId).setPaperDeadline(date);
    }

    public void changeBidDeadline(Long conferenceId, Long userId, Date date){
        //toDo: check if the conference exists
        if (isConferenceChair(conferenceId, userId) || isConferenceCoChair(conferenceId, userId))
            this.conferenceRepository.getOne(conferenceId).setBidDeadline(date);
    }

    public void changeReviewDeadline(Long conferenceId, Long userId, Date date){
        //toDo: check if the conference exists
        if (isConferenceChair(conferenceId, userId) || isConferenceCoChair(conferenceId, userId))
            this.conferenceRepository.getOne(conferenceId).setReviewDeadline(date);
    }
}
