package ro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.repository.CChairRepository;
import ro.repository.ConferenceRepository;
import ro.repository.SectionRepository;

@Component
public class ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private CChairRepository cChairRepository;

    public ConferenceService() {
    }


}
