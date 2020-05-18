package ro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.domain.*;
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

    public List<UserConference> getUserConferences(){return this.userConferenceRepository.findAll();}

    //public List<Conference> getConferencesDesc(){return this.userConferenceRepository.findAll();}

    public boolean isConferenceChair(Long conferenceId, Long userId) {
        //toDo: check if the conference exists
        Conference conference = this.conferenceRepository.getOne(conferenceId);
        return this.pcMemberRepository.findById(this.cChairRepository.findById(conference.getChair_id())
                .get().getUser_id()).get().getUser_id().equals(userId);
    }

    public boolean isConferenceCoChair(Long conferenceId, Long userId) {
        //toDo: check if the conference exists
        Conference conference = this.conferenceRepository.getOne(conferenceId);
        return this.pcMemberRepository.findById(this.cChairRepository.findById(conference.getCo_chair_id())
                .get().getUser_id()).get().getUser_id().equals(userId);
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

    public Conference getConferenceFromId(Long id){
        return conferenceRepository.findById(id).orElse(null);
    }

    public Conference addConference(String name, Long chair_id, Long co_chair_id, Date startingDate, Date endingDate, Date abstractDeadline, Date paperDeadline,Date bidDeadline, Date reviewDeadline){
        return this.conferenceRepository.save(new Conference(name,abstractDeadline,paperDeadline,bidDeadline,reviewDeadline,startingDate,endingDate,chair_id,co_chair_id));
    }

    public Conference getConferenceFromName(String name){
        for(Conference conference: this.conferenceRepository.findAll()){
            if(conference.getName().equals(name)) return conference;
        }
        return null;
    }
}
