package ubbproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubbproject.domain.Presentation;
import ubbproject.repository.*;

import java.util.List;

@Service
public class ServicePresentation implements ServicePresentationInterface {
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

    public ServicePresentation() {
    }

    @Override
    public void addPresentation(Presentation presentation) {
        this.repositoryPresentation.save(presentation);
    }

    @Override
    public void deletePresentation(Integer id) {
        this.repositoryPresentation.deleteById(id);
    }

    @Override
    public void updatePresentation(Presentation presentation) {
        this.repositoryPresentation.findById(presentation.getId())
                .ifPresent(s -> {
                    s.setSection(presentation.getSection());
                    s.setTime(presentation.getTime());
                    s.setChairId(presentation.getChairId());
                });
    }

    @Override
    public List<Presentation> getAllPresentations() {
        return this.repositoryPresentation.findAll();
    }
}
