package ro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.domain.Conference;
import ro.repository.CChairRepository;
import ro.repository.ConferenceRepository;
import ro.repository.SectionRepository;
import ro.repository.UserConferenceRepository;

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
    private UserConferenceRepository userConferenceRepository;

    public ConferenceService() {
    }


    public List<Conference> getConferences() {
        return null;
    }
}
