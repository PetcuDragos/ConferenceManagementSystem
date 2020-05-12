package ubbproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ubbproject.repository.CChairRepository;
import ubbproject.repository.ConferenceRepository;
import ubbproject.repository.SectionRepository;

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
