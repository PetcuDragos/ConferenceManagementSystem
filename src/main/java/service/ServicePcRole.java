package service;

import domain.PcRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.*;

import java.util.List;

@Service
public class ServicePcRole implements ServicePcRoleInterface{
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

    public ServicePcRole() {
    }

    @Override
    public void addPcRole(PcRole pcRole) {
        this.repositoryPcRole.save(pcRole);
    }

    @Override
    public void deletePcRole(Integer id) {
        this.repositoryPcRole.deleteById(id);
    }

    @Override
    public void updatePcRole(PcRole pcRole) {
        this.repositoryPcRole.findById(pcRole.getId())
                .ifPresent(s -> {
                    s.setDescription(pcRole.getDescription());
                });
    }

    @Override
    public List<PcRole> getAllPcRoles() {
        return repositoryPcRole.findAll();
    }
}
