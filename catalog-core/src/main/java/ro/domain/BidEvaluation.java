package ro.domain;

import javax.persistence.*;

@Entity
public class BidEvaluation extends BaseEntity{

    private Long pc_id;
    private Long abstract_id;
    private int result;
    private Date date;

    public BidEvaluation() {
    }

    public BidEvaluation(Long pc_id, Long abstract_id, int result, Date date) {
        this.pc_id = pc_id;
        this.abstract_id = abstract_id;
        this.result = result;
        this.date = date;
    }

    public Long getPc_id() {
        return pc_id;
    }

    public void setPc_id(Long pc_id) {
        this.pc_id = pc_id;
    }

    public Long getAbstract_id() {
        return abstract_id;
    }

    public void setAbstract_id(Long abstract_id) {
        this.abstract_id = abstract_id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BidEvaluation{" +
                "pc_id=" + pc_id +
                ", abstract_id=" + abstract_id +
                ", result=" + result +
                ", date=" + date +
                '}';
    }
}
