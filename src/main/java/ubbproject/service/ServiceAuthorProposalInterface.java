package ubbproject.service;

import ubbproject.domain.AuthorProposal;

import java.util.List;

public interface ServiceAuthorProposalInterface {

    void addAuthorProposal(AuthorProposal authorProposal);

    void deleteAuthorProposal(Integer id);

    void updateAuthorProposal(AuthorProposal authorProposal);

    List<AuthorProposal> getAllAuthorProposals();
}
