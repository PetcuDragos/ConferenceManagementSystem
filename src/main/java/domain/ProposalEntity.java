package domain;

import javax.persistence.*;

@Entity
@Table(name = "Proposal", schema = "dbo", catalog = "conference")
public class ProposalEntity {
    private Integer proposalId;
    private String keywords;
    private String topic;
    private String abstractPaper;
    private String fullPaper;

    @Id
    @Column(name = "ProposalID")
    public Integer getProposalId() {
        return proposalId;
    }

    public void setProposalId(Integer proposalId) {
        this.proposalId = proposalId;
    }

    @Basic
    @Column(name = "Keywords")
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Basic
    @Column(name = "Topic")
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Basic
    @Column(name = "Abstract")
    public String getAbstractPaper() {
        return abstractPaper;
    }

    public void setAbstractPaper(String abstractPaper) {
        this.abstractPaper = abstractPaper;
    }

    @Basic
    @Column(name = "FullPaper")
    public String getFullPaper() {
        return fullPaper;
    }

    public void setFullPaper(String fullPaper) {
        this.fullPaper = fullPaper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProposalEntity that = (ProposalEntity) o;

        if (proposalId != null ? !proposalId.equals(that.proposalId) : that.proposalId != null) return false;
        if (keywords != null ? !keywords.equals(that.keywords) : that.keywords != null) return false;
        if (topic != null ? !topic.equals(that.topic) : that.topic != null) return false;
        if (abstractPaper != null ? !abstractPaper.equals(that.abstractPaper) : that.abstractPaper != null)
            return false;
        if (fullPaper != null ? !fullPaper.equals(that.fullPaper) : that.fullPaper != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = proposalId != null ? proposalId.hashCode() : 0;
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (abstractPaper != null ? abstractPaper.hashCode() : 0);
        result = 31 * result + (fullPaper != null ? fullPaper.hashCode() : 0);
        return result;
    }
}
