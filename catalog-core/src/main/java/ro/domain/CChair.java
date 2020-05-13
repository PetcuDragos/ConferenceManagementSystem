package ro.domain;

import javax.persistence.Entity;

@Entity
public class CChair extends BaseEntity<Long>{
    private Long pc_id;

    public CChair(Long pc_id) {
        this.pc_id = pc_id;
    }

    public CChair(){}

    public Long getPc_id() {
        return pc_id;
    }

    public void setPc_id(Long pc_id) {
        this.pc_id = pc_id;
    }

    @Override
    public String toString() {
        return "CChair{" +
                "pc_id=" + pc_id +
                '}';
    }
}
