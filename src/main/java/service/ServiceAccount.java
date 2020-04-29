package service;

import domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import repository.*;

import java.util.List;

@Service
public class ServiceAccount implements ServiceAccountInterface{
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

    public ServiceAccount() {
    }

    @Override
    public void addAccount(Account account) {
        this.repositoryAccount.save(account);
    }

    @Override
    public void deleteAccount(Integer id) {
        this.repositoryAccount.deleteById(id);
    }

    @Override
    public void updateAccount(Account account) {
        this.repositoryAccount.findById(account.getId())
                .ifPresent(s -> {
                    s.setFullName(account.getFullName());
                    s.setAffiliation(account.getAffiliation());
                    s.setEmail(account.getEmail());
                    s.setUsername(account.getUsername());
                    s.setPassword(account.getPassword());
                });
    }

    @Override
    public List<Account> getAllAccounts() {
        return this.repositoryAccount.findAll();
    }
}
