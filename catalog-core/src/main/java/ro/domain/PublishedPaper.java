package ro.domain;

import javax.persistence.Entity;

@Entity
public class PublishedPaper extends BaseEntity {

    private Long paper_id;
    private Long section_id;

    public PublishedPaper(){}

    public PublishedPaper(Long paper_id){
        this.paper_id = paper_id;
        this.section_id = null;
    }

    public PublishedPaper(Long paper_id, Long section_id){
        this.paper_id = paper_id;
        this.section_id = section_id;
    }

    public Long getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(Long paper_id) {
        this.paper_id = paper_id;
    }

    public Long getSection_id() {
        return section_id;
    }

    public void setSection_id(Long section_id) {
        this.section_id = section_id;
    }

    @Override
    public String toString() {
        return "PublishedPaper{" +
                "paper_id=" + paper_id +
                '}';
    }
}
