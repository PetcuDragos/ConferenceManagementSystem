package domain;

import javax.persistence.*;

@Entity
@Table(name = "ProposalReview", schema = "dbo", catalog = "conference")
@IdClass(ProposalReviewEntityPK.class)
public class ProposalReviewEntity {
    private Integer pcMemberId;
    private Integer proposalId;
    private String status;

    @Id
    @Column(name = "PCMemberID")
    public Integer getPcMemberId() {
        return pcMemberId;
    }

    public void setPcMemberId(Integer pcMemberId) {
        this.pcMemberId = pcMemberId;
    }

    @Id
    @Column(name = "ProposalID")
    public Integer getProposalId() {
        return proposalId;
    }

    public void setProposalId(Integer proposalId) {
        this.proposalId = proposalId;
    }

    @Basic
    @Column(name = "Status")
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

        if (pcMemberId != null ? !pcMemberId.equals(that.pcMemberId) : that.pcMemberId != null) return false;
        if (proposalId != null ? !proposalId.equals(that.proposalId) : that.proposalId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pcMemberId != null ? pcMemberId.hashCode() : 0;
        result = 31 * result + (proposalId != null ? proposalId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
