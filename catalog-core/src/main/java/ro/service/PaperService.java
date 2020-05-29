package ro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.domain.Abstract;
import ro.domain.MyUser;
import ro.domain.Paper;
import ro.domain.PublishedPaper;
import ro.repository.AbstractRepository;
import ro.repository.PaperRepository;
import ro.repository.PublishedPaperRepository;

import javax.mail.MessagingException;
import java.io.File;
import java.util.List;

@Component
public class PaperService {

    @Autowired
    private PaperRepository paperRepository;
    @Autowired
    private AbstractRepository abstractRepository;
    @Autowired
    private PublishedPaperRepository publishedPaperRepository;

    public PaperService() {
    }

    public List<Paper> getPapers() {
        return this.paperRepository.findAll();
    }

    public List<PublishedPaper> getPublishedPapers() {
        return this.publishedPaperRepository.findAll();
    }

    public List<Abstract> getAbstracts() {
        return this.abstractRepository.findAll();
    }

    public Paper addPaper(Long abstract_id, String document, Long conference_id, Long author_id) {
        return paperRepository.save(new Paper(abstract_id, document, conference_id, author_id));
    }

    public Abstract addAbstract(String keywords, String topics, String name, String additionalAuthors, String content, Long author_id, Long conference_id) {
        return abstractRepository.save(new Abstract(keywords, topics, name, additionalAuthors, content, author_id, conference_id));
    }

    public Abstract getAbstractById(Long id) {
        return this.abstractRepository.findById(id).orElse(null);
    }

    public Paper getPaperFromAbstractId(Long abstract_id) {
        return this.paperRepository.findAll().stream().filter(p -> p.getAbstract_id().equals(abstract_id)).findAny().orElse(null);
    }

    public File addFile(String url) {
        File directory = new File("/resources");
        if (!directory.exists()) {
            if (directory.mkdir()) {
                return new File("/resources/" + url);
            } else {
                System.out.println("Failed to create directory!");
                return null;
            }
        } else {
            return new File("/resources/" + url);
        }
    }

    public String getUrl(Long abstract_id) {
        Paper p = getPaperFromAbstractId(abstract_id);
        if (p == null || p.getDocument() == null) return null;
        else return p.getDocument();
    }

    public void addPublishedPaper(Long paper_id, Long section_id, MyUser user) {
        PublishedPaper pu = publishedPaperRepository.findAll().stream().filter(p -> p.getPaper_id().equals(paper_id)).findAny().orElse(null);
        if (pu == null) {
            publishedPaperRepository.save(new PublishedPaper(paper_id, section_id));
            try {
                MemberService.sendMailPaperAccepted(user.getEmail(), user.getFullName());
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

    @Transactional
    public void updatePublishedPaperSection(Long paper_id, Long section_id) {
        this.getPublishedPapers().stream().filter(p -> p.getPaper_id().equals(paper_id)).findAny().ifPresent(publishedPaper -> publishedPaper.setSection_id(section_id));

    }
}
