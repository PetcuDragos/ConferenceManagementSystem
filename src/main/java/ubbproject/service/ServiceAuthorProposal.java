package ubbproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubbproject.domain.AuthorProposal;
import ubbproject.repository.*;

import java.util.List;

@Service
public class ServiceAuthorProposal implements ServiceAuthorProposalInterface {
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

    public ServiceAuthorProposal() {
    }

    @Override
    public void addAuthorProposal(AuthorProposal authorProposal) {
        this.repositoryAuthorProposal.save(authorProposal);
    }

    @Override
    public void deleteAuthorProposal(Integer id) {
        this.repositoryAuthorProposal.deleteById(id);
    }

    @Override
    public void updateAuthorProposal(AuthorProposal authorProposal) {
        this.repositoryAuthorProposal.findById(authorProposal.getId())
                .ifPresent(s -> {
                    s.setProposalId(authorProposal.getProposalId());
                    s.setAuthorId(authorProposal.getAuthorId());
                });
    }

    @Override
    public List<AuthorProposal> getAllAuthorProposals() {
        return this.repositoryAuthorProposal.findAll();
    }
}
