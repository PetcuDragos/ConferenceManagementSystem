package ubbproject.domain;

import javax.persistence.*;

@Entity
public class PcMember extends BaseEntity<Long>{
    private Long conference_id;
    private Long user_id;

    public PcMember() {
    }

    public PcMember(Long user_id, Long conference_id){
        this.conference_id = conference_id;
        this.user_id = user_id;
    }

    public Long getConference_id() {
        return conference_id;
    }

    public void setConference_id(Long conference_id) {
        this.conference_id = conference_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "PcMember{" +
                "conference_id=" + conference_id +
                ", user_id=" + user_id +
                '}';
    }
}
