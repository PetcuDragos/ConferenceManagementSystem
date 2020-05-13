package ro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.domain.Paper;
import ro.repository.AbstractRepository;
import ro.repository.AuthorRepository;
import ro.repository.PaperRepository;
import ro.repository.SectionRepository;

import java.util.List;

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

    public List<Paper> getPapers(){
        return this.paperRepository.findAll();
    }

}
