package domain;

import javax.persistence.*;

@Entity
@Table(name = "ProposalReview", schema = "dbo", catalog = "conference")
@IdClass(ProposalReviewEntityPK.class)
public class ProposalReviewEntity {
    private int pcMemberId;
    private int proposalId;
    private String status;

    @Id
    @Column(name = "PCMemberID", nullable = false)
    public int getPcMemberId() {
        return pcMemberId;
    }

    public void setPcMemberId(int pcMemberId) {
        this.pcMemberId = pcMemberId;
    }

    @Id
    @Column(name = "ProposalID", nullable = false)
    public int getProposalId() {
        return proposalId;
    }

    public void setProposalId(int proposalId) {
        this.proposalId = proposalId;
    }

    @Basic
    @Column(name = "Status", nullable = true, length = 50)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProposalReviewEntity that = (ProposalReviewEntity) o;

        if (pcMemberId != that.pcMemberId) return false;
        if (proposalId != that.proposalId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pcMemberId;
        result = 31 * result + proposalId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
