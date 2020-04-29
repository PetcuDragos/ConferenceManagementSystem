package ubbproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubbproject.domain.Proposal;
import ubbproject.repository.*;

import java.util.List;

@Service
public class ServiceProposal implements ServiceProposalInterface {
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

    public ServiceProposal() {
    }

    @Override
    public void addProposal(Proposal proposal) {
        this.repositoryProposal.save(proposal);
    }

    @Override
    public void deleteProposal(Integer id) {
        this.repositoryProposal.deleteById(id);
    }

    @Override
    public void updateProposal(Proposal proposal) {
        this.repositoryProposal.findById(proposal.getId())
                .ifPresent(s -> {
                    s.setKeywords(proposal.getKeywords());
                    s.setTopic(s.getTopic());
                    s.setAbstractPaper(s.getAbstractPaper());
                    s.setFullPaper(s.getFullPaper());
                });
    }

    @Override
    public List<Proposal> getAllProposals() {
        return this.repositoryProposal.findAll();
    }
}
