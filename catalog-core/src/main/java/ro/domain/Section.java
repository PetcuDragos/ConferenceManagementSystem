package ro.domain;

import javax.persistence.Entity;

@Entity
public class Section extends BaseEntity {
    private Long sc_id;
    private Long conference_id;

    public Section(Long sc_id, Long conference_id) {
        this.conference_id = conference_id;
        this.sc_id = sc_id;
    }

    public Section() {
    }

    public Long getSc_id() {
        return sc_id;
    }

    public void setSc_id(Long sc_id) {
        this.sc_id = sc_id;
    }

    public Long getConference_id() {
        return conference_id;
    }

    public void setConference_id(Long conference_id) {
        this.conference_id = conference_id;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sc_id=" + sc_id +
                ", conference_id=" + conference_id +
                '}';
    }
}
