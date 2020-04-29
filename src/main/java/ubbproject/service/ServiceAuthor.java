package ubbproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubbproject.domain.Author;
import ubbproject.repository.*;

import java.util.List;

@Service
public class ServiceAuthor implements ServiceAuthorInterface {
    @Autowired
    private RepositoryAccount repositoryAccount;
    @Autowired
    private RepositoryAuthor repositoryAuthor;
    @Autowired
    private RepositoryAuthorProposal repositoryAuthorProposal;
    @Autowired
    private RepositoryParticipant repositoryParticipant;
    @Autowired
    private RepositoryPcMember repositoryPcMember;
    @Autowired
    private RepositoryPcRole repositoryPcRole;
    @Autowired
    private RepositoryPresentation repositoryPresentation;
    @Autowired
    private RepositoryPresentationParticipant repositoryPresentationParticipant;
    @Autowired
    private RepositoryPresentationRole repositoryPresentationRole;
    @Autowired
    private RepositoryProposal repositoryProposal;
    @Autowired
    private RepositoryProposalReview repositoryProposalReview;

    public ServiceAuthor() {
    }

    @Override
    public void addAuthor(Author author) {
        this.repositoryAuthor.save(author);
    }

    @Override
    public void deleteAuthor(Integer id) {
        this.repositoryAuthor.deleteById(id);
    }

    @Override
    public void updateAuthor(Author author) {
        this.repositoryAuthor.findById(author.getId())
                .ifPresent(s -> {
                    s.setFullName(author.getFullName());
                    s.setAffiliation(author.getAffiliation());
                    s.setEmail(author.getEmail());
                });
    }

    @Override
    public List<Author> getAllAuthors() {
        return this.repositoryAuthor.findAll();
    }
}
