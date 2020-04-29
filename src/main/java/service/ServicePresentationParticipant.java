package service;

import domain.PresentationParticipant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.*;

import java.util.List;

@Service
public class ServicePresentationParticipant implements ServicePresentationParticipantInterface{
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

    public ServicePresentationParticipant() {
    }

    @Override
    public void addPresentationParticipant(PresentationParticipant presentationParticipant) {
        this.repositoryPresentationParticipant.save(presentationParticipant);
    }

    @Override
    public void deletePresentationParticipant(Integer id) {
        this.repositoryPresentationParticipant.deleteById(id);
    }

    @Override
    public void updatePresentationParticipant(PresentationParticipant presentationParticipant) {
        this.repositoryPresentationParticipant.findById(presentationParticipant.getId())
                .ifPresent(s -> {
                    s.setParticipantID(presentationParticipant.getParticipantID());
                    s.setPresentationId(presentationParticipant.getPresentationId());
                    s.setPresentationRoleId(presentationParticipant.getPresentationRoleId());
                });
    }

    @Override
    public List<PresentationParticipant> getAllPresentationParticipants() {
        return this.repositoryPresentationParticipant.findAll();
    }
}
