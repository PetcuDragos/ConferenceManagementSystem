package domain;

import javax.persistence.Entity;

@Entity
public class ProposalReview extends BaseEntity<Integer>{

    private int pcMemberId;
    private int proposalId;
    private String status;

    public ProposalReview() {
    }

    public ProposalReview(int pcMemberId, int proposalId, String status) {
        this.pcMemberId = pcMemberId;
        this.proposalId = proposalId;
        this.status = status;
    }

    public ProposalReview(int id, int pcMemberId, int proposalId, String status) {
        this.pcMemberId = pcMemberId;
        this.proposalId = proposalId;
        this.status = status;
        this.setId(id);
    }

    public int getPcMemberId() {
        return pcMemberId;
    }

    public void setPcMemberId(int pcMemberId) {
        this.pcMemberId = pcMemberId;
    }

    public int getProposalId() {
        return proposalId;
    }

    public void setProposalId(int proposalId) {
        this.proposalId = proposalId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProposalReview{" +
                "id=" + this.getId() +
                "pcMemberId=" + pcMemberId +
                ", proposalId=" + proposalId +
                ", status='" + status + '\'' +
                '}';
    }
}
