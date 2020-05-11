package ubbproject.domain;

import javax.persistence.Entity;

@Entity
public class Paper extends BaseEntity<Long>{

    private Long abstract_id;
    private Long section_id;

    public Paper() {
    }

    public Paper(Long abstract_id, Long section_id) {
        this.abstract_id = abstract_id;
        this.section_id = section_id;
    }

    public Paper(Long abstract_id) {
        this.abstract_id = abstract_id;
        this.section_id = null;
    }

    public Long getAbstract_id() {
        return abstract_id;
    }

    public void setAbstract_id(Long abstract_id) {
        this.abstract_id = abstract_id;
    }

    public Long getSection_id() {
        return section_id;
    }

    public void setSection_id(Long section_id) {
        this.section_id = section_id;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "abstract_id=" + abstract_id +
                ", section_id=" + section_id +
                '}';
    }
}
