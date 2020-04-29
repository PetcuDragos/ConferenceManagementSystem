package ubbproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubbproject.domain.PresentationRole;
import ubbproject.repository.*;

import java.util.List;

@Service
public class ServicePresentationRole implements ServicePresentationRoleInterface {
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

    public ServicePresentationRole() {
    }

    @Override
    public void addPresentationRole(PresentationRole presentationRole) {
        this.repositoryPresentationRole.save(presentationRole);
    }

    @Override
    public void deletePresentationRole(Integer id) {
        this.repositoryPresentationRole.deleteById(id);
    }

    @Override
    public void updatePresentationRole(PresentationRole presentationRole) {
        this.repositoryPresentationRole.findById(presentationRole.getId())
                .ifPresent(s -> {
                    s.setDescription(presentationRole.getDescription());
                });
    }

    @Override
    public List<PresentationRole> getAllPresentationRoles() {
        return this.repositoryPresentationRole.findAll();
    }
}
