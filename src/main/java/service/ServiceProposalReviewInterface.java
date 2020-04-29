package service;

import domain.ProposalReview;

import java.util.List;

public interface ServiceProposalReviewInterface {

    void addProposalReview(ProposalReview proposalReview);

    void deleteProposalReview(Integer id);

    void updateProposalReview(ProposalReview proposalReview);

    List<ProposalReview> getAllProposalReviews();
}
