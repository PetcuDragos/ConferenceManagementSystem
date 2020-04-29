package ubbproject.domain;

import javax.persistence.*;

@Entity
public class AuthorProposal extends BaseEntity<Integer>{
    private int proposalId;
    private int authorId;

    public AuthorProposal(int proposalId, int authorId) {
        this.proposalId = proposalId;
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "AuthorProposal{" +
                "Id=" + this.getId() +
                "ProposalId=" + proposalId +
                ", AuthorId=" + authorId +
                '}';
    }

    public int getProposalId() {
        return proposalId;
    }

    public void setProposalId(int proposalId) {
        this.proposalId = proposalId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public AuthorProposal(int id, int proposalId, int authorId) {
        this.proposalId = proposalId;
        this.authorId = authorId;
        this.setId(id);
    }

    public AuthorProposal() {
    }
}
