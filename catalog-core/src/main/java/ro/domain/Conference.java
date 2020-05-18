package ro.domain;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.Entity;
@Transactional
@Entity
public class Conference extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String name;
    private Date abstractDeadline;
    private Date paperDeadline;
    private Date bidDeadline;
    private Date reviewDeadline;
    private Date startingDate;
    private Date endingDate;
    private Long chair_id;
    private Long co_chair_id;

    public Conference() {
    }

    public Conference(String name, Date abstractDeadline, Date paperDeadline, Date bidDeadline, Date reviewDeadline, Date startingDate, Date endingDate, Long chair_id, Long co_chair_id) {
        this.name = name;
        this.abstractDeadline = abstractDeadline;
        this.paperDeadline = paperDeadline;
        this.bidDeadline = bidDeadline;
        this.reviewDeadline = reviewDeadline;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.chair_id = chair_id;
        this.co_chair_id = co_chair_id;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "name='" + name + '\'' +
                ", abstractDeadline=" + abstractDeadline +
                ", paperDeadline=" + paperDeadline +
                ", bidDeadline=" + bidDeadline +
                ", reviewDeadline=" + reviewDeadline +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", chair_id=" + chair_id +
                ", co_chair_id=" + co_chair_id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAbstractDeadline() {
        return abstractDeadline;
    }

    public void setAbstractDeadline(Date abstractDeadline) {
        this.abstractDeadline = abstractDeadline;
    }

    public Date getPaperDeadline() {
        return paperDeadline;
    }

    public void setPaperDeadline(Date paperDeadline) {
        this.paperDeadline = paperDeadline;
    }

    public Date getBidDeadline() {
        return bidDeadline;
    }

    public void setBidDeadline(Date bidDeadline) {
        this.bidDeadline = bidDeadline;
    }

    public Date getReviewDeadline() {
        return reviewDeadline;
    }

    public void setReviewDeadline(Date reviewDeadline) {
        this.reviewDeadline = reviewDeadline;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public Long getChair_id() {
        return chair_id;
    }

    public void setChair_id(Long chair_id) {
        this.chair_id = chair_id;
    }

    public Long getCo_chair_id() {
        return co_chair_id;
    }

    public void setCo_chair_id(Long co_chair_id) {
        this.co_chair_id = co_chair_id;
    }
}
