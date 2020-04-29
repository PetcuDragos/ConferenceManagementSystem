package service;

import domain.ProposalReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.*;

import java.util.List;

@Service
public class ServiceProposalReview implements ServiceProposalReviewInterface{
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

    public ServiceProposalReview() {
    }

    @Override
    public void addProposalReview(ProposalReview proposalReview) {
        this.repositoryProposalReview.save(proposalReview);
    }

    @Override
    public void deleteProposalReview(Integer id) {
        this.repositoryProposalReview.deleteById(id);
    }

    @Override
    public void updateProposalReview(ProposalReview proposalReview) {
        this.repositoryProposalReview.findById(proposalReview.getId())
                .ifPresent(s -> {
                    s.setPcMemberId(proposalReview.getPcMemberId());
                    s.setProposalId(proposalReview.getProposalId());
                    s.setStatus(proposalReview.getStatus());
                });
    }

    @Override
    public List<ProposalReview> getAllProposalReviews() {
        return this.repositoryProposalReview.findAll();
    }
}
