package service;

import domain.PcMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.*;

import java.util.List;

@Service
public class ServicePcMember implements ServicePcMemberInterface{
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

    public ServicePcMember() {
    }

    @Override
    public void addPcMember(PcMember pcMember) {
        this.repositoryPcMember.save(pcMember);
    }

    @Override
    public void deletePcMember(Integer id) {
        this.repositoryPcMember.deleteById(id);
    }

    @Override
    public void updatePcMember(PcMember pcMember) {
        this.repositoryPcMember.findById(pcMember.getId())
                .ifPresent(s -> {
                    s.setAccountId(pcMember.getAccountId());
                    s.setPcRoleId(pcMember.getPcRoleId());
                    s.setWebsite(pcMember.getWebsite());
                });
    }

    @Override
    public List<PcMember> getAllPcMembers() {
        return this.repositoryPcMember.findAll();
    }
}
