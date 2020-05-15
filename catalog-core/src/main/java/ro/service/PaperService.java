package ro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.domain.Abstract;
import ro.domain.Author;
import ro.domain.Paper;
import ro.domain.Section;
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

    public List<Section> getSection(){return this.sectionRepository.findAll();}

    public List<Abstract> getAbstracts(){return this.abstractRepository.findAll();}

    public List<Author> getAuthors(){return this.authorRepository.findAll();}

    public Paper addPaper(Long abstract_id, Long section_id, String document, Long conference_id, Long author_id){
        return paperRepository.save(new Paper(abstract_id,section_id,document, conference_id, author_id));
    }

    public Abstract addAbstract(String keywords, String topics, String name, String additionalAuthors, String content, Long author_id, Long conference_id){
        return abstractRepository.save(new Abstract(keywords,topics,name,additionalAuthors,content,author_id,conference_id));
    }
}
