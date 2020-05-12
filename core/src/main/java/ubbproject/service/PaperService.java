package ubbproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ubbproject.repository.AbstractRepository;
import ubbproject.repository.AuthorRepository;
import ubbproject.repository.PaperRepository;
import ubbproject.repository.SectionRepository;

@Component
public class PaperService {

    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private PaperRepository paperRepository;
    @Autowired
    private AbstractRepository abstractRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public PaperService() {
    }

}
