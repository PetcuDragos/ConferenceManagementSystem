package domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ProposalReviewEntityPK implements Serializable {
    private int pcMemberId;
    private int proposalId;

    @Column(name = "PCMemberID", nullable = false)
    @Id
    public int getPcMemberId() {
        return pcMemberId;
    }

    public void setPcMemberId(int pcMemberId) {
        this.pcMemberId = pcMemberId;
    }

    @Column(name = "ProposalID", nullable = false)
    @Id
    public int getProposalId() {
        return proposalId;
    }

    public void setProposalId(int proposalId) {
        this.proposalId = proposalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProposalReviewEntityPK that = (ProposalReviewEntityPK) o;

        if (pcMemberId != that.pcMemberId) return false;
        if (proposalId != that.proposalId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pcMemberId;
        result = 31 * result + proposalId;
        return result;
    }
}
