package domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AuthorProposalEntityPK implements Serializable {
    private Integer proposalId;
    private Integer authorId;

    @Column(name = "ProposalID")
    @Id
    public Integer getProposalId() {
        return proposalId;
    }

    public void setProposalId(Integer proposalId) {
        this.proposalId = proposalId;
    }

    @Column(name = "AuthorID")
    @Id
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorProposalEntityPK that = (AuthorProposalEntityPK) o;

        if (proposalId != null ? !proposalId.equals(that.proposalId) : that.proposalId != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = proposalId != null ? proposalId.hashCode() : 0;
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        return result;
    }
}
