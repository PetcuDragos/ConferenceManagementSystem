package service;

import domain.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.*;

import java.util.List;

@Service
public class ServiceParticipant implements ServiceParticipantInterface{
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

    public ServiceParticipant() {
    }

    @Override
    public void addParticipant(Participant participant) {
        this.repositoryParticipant.save(participant);
    }

    @Override
    public void deleteParticipant(Integer id) {
        this.repositoryParticipant.deleteById(id);
    }

    @Override
    public void updateParticipant(Participant participant) {
        this.repositoryParticipant.findById(participant.getId())
                .ifPresent(s -> {
                    s.setAccountId(participant.getAccountId());
                    s.setAuthorId(participant.getAuthorId());
                });
    }

    @Override
    public List<Participant> getAllParticipants() {
        return this.repositoryParticipant.findAll();
    }
}
