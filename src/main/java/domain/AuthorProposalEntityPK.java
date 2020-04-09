package domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AuthorProposalEntityPK implements Serializable {
    private int proposalId;
    private int authorId;

    @Column(name = "ProposalID", nullable = false)
    @Id
    public int getProposalId() {
        return proposalId;
    }

    public void setProposalId(int proposalId) {
        this.proposalId = proposalId;
    }

    @Column(name = "AuthorID", nullable = false)
    @Id
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorProposalEntityPK that = (AuthorProposalEntityPK) o;

        if (proposalId != that.proposalId) return false;
        if (authorId != that.authorId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = proposalId;
        result = 31 * result + authorId;
        return result;
    }
}
