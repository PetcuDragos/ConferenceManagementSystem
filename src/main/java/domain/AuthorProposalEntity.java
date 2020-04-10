package domain;

import javax.persistence.*;

@Entity
@Table(name = "AuthorProposal", schema = "dbo", catalog = "conference")
@IdClass(AuthorProposalEntityPK.class)
public class AuthorProposalEntity {
    private AuthorProposalEntityPK primaryKey;
    //private int proposalId;
    //private int authorId;

    @Id
    @Column(name = "ProposalID", nullable = false)
    public int getProposalId() {
        return primaryKey.getProposalId();//proposalId;
    }

    public void setProposalId(int proposalId) {
        this.primaryKey.setProposalId(proposalId);
    }

    @Id
    @Column(name = "AuthorID", nullable = false)
    public int getAuthorId() {
        return primaryKey.getAuthorId();//authorId;
    }

    public void setAuthorId(int authorId) {
        this.primaryKey.setAuthorId(authorId);// = authorId;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorProposalEntity that = (AuthorProposalEntity) o;

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
     */
}
