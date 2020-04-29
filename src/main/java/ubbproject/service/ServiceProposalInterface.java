package ubbproject.service;

import ubbproject.domain.Proposal;

import java.util.List;

public interface ServiceProposalInterface {

    void addProposal(Proposal proposal);

    void deleteProposal(Integer id);

    void updateProposal(Proposal proposal);

    List<Proposal> getAllProposals();
}
