package domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ProposalReviewEntityPK implements Serializable {
    private Integer pcMemberId;
    private Integer proposalId;

    @Column(name = "PCMemberID")
    @Id
    public Integer getPcMemberId() {
        return pcMemberId;
    }

    public void setPcMemberId(Integer pcMemberId) {
        this.pcMemberId = pcMemberId;
    }

    @Column(name = "ProposalID")
    @Id
    public Integer getProposalId() {
        return proposalId;
    }

    public void setProposalId(Integer proposalId) {
        this.proposalId = proposalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProposalReviewEntityPK that = (ProposalReviewEntityPK) o;

        if (pcMemberId != null ? !pcMemberId.equals(that.pcMemberId) : that.pcMemberId != null) return false;
        if (proposalId != null ? !proposalId.equals(that.proposalId) : that.proposalId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pcMemberId != null ? pcMemberId.hashCode() : 0;
        result = 31 * result + (proposalId != null ? proposalId.hashCode() : 0);
        return result;
    }
}
