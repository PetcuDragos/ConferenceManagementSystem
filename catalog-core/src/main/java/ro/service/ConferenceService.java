package ro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.domain.*;
import ro.repository.*;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;


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
    private AuthorRepository authorRepository;

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

    //todo de refacut aceste functii
//    public void changePaperDeadline(Long conferenceId, Long userId, Date date){
//        //toDo: check if the conference exists
//        if (isConferenceChair(conferenceId, userId) || isConferenceCoChair(conferenceId, userId))
//            this.conferenceRepository.fingetOne(conferenceId).setPaperDeadline(date);
//    }
//
//    public void changeBidDeadline(Long conferenceId, Long userId, Date date){
//        //toDo: check if the conference exists
//        if (isConferenceChair(conferenceId, userId) || isConferenceCoChair(conferenceId, userId))
//            this.conferenceRepository.getOne(conferenceId).setBidDeadline(date);
//    }
//
//    public void changeReviewDeadline(Long conferenceId, Long userId, Date date){
//        //toDo: check if the conference exists
//        if (isConferenceChair(conferenceId, userId) || isConferenceCoChair(conferenceId, userId))
//            this.conferenceRepository.getOne(conferenceId).setReviewDeadline(date);
//    }

    public Conference getConferenceFromId(Long id){
        return conferenceRepository.findById(id).orElse(null);
    }

    public Conference addConference(String name, Long chair_id, Long co_chair_id, Date startingDate, Date endingDate, Date abstractDeadline, Date paperDeadline,Date bidDeadline, Date reviewDeadline){

        return this.conferenceRepository.save(new Conference(name,
           java.sql.Date.valueOf(abstractDeadline.getYear().toString()+'-'+abstractDeadline.getMonth().toString()+'-' + abstractDeadline.getDay().toString()),
           java.sql.Date.valueOf(paperDeadline.getYear().toString()+'-'+paperDeadline.getMonth().toString()+'-' + paperDeadline.getDay().toString()),
           java.sql.Date.valueOf(bidDeadline.getYear().toString()+'-'+bidDeadline.getMonth().toString()+'-' + bidDeadline.getDay().toString()),
           java.sql.Date.valueOf(reviewDeadline.getYear().toString()+'-'+reviewDeadline.getMonth().toString()+'-' + reviewDeadline.getDay().toString()),
           java.sql.Date.valueOf(startingDate.getYear().toString()+'-'+startingDate.getMonth().toString()+'-' + startingDate.getDay().toString()),
           java.sql.Date.valueOf(endingDate.getYear().toString()+'-'+endingDate.getMonth().toString()+'-' + endingDate.getDay().toString()),
           chair_id,co_chair_id));

    }

    public java.sql.Date transformMyDateIntoSQLDate(Date myDate){
        return java.sql.Date.valueOf(myDate.getYear().toString()+'-'+myDate.getMonth().toString()+'-' + myDate.getDay().toString());
    }

    public Date transformSQLDateIntoMyDate(java.sql.Date sqlDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(sqlDate);
        return new Date(cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH)+1,cal.get(Calendar.YEAR));
    }

    public Conference getConferenceFromName(String name){
        for(Conference conference: this.conferenceRepository.findAll()){
            if(conference.getName().equals(name)) return conference;
        }
        return null;
    }

    public void joinConference(long userId, long conferenceId){
        int x = 0;
        this.userConferenceRepository.save(new UserConference(conferenceId, userId));
    }

    // TODO: A
    public Author getAuthor(Long conferenceId, Long userId) {
        List<Author> authors = this.authorRepository.findAll().stream()
                .filter(author -> author.getConference_id().equals(conferenceId) && author.getUser_id().equals(userId))
                .collect(Collectors.toList());
        if (authors.isEmpty()) {
            return null;
        }
        return authors.get(0);
    }
}
