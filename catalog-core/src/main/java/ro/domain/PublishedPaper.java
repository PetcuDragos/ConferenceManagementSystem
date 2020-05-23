package ro.domain;

import javax.persistence.Entity;

@Entity
public class PublishedPaper extends BaseEntity {

    private Long paper_id;

    public PublishedPaper(){}

    public PublishedPaper(Long paper_id){
        this.paper_id = paper_id;
    }

    public Long getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(Long paper_id) {
        this.paper_id = paper_id;
    }

    @Override
    public String toString() {
        return "PublishedPaper{" +
                "paper_id=" + paper_id +
                '}';
    }
}
