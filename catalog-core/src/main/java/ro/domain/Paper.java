package ro.domain;

import javax.persistence.Entity;

@Entity
public class Paper extends BaseEntity{

    private Long abstract_id;
    private String document;
    private Long conference_id;
    private Long author_id;

    public Paper() {
    }

    public Paper(Long abstract_id, String document, Long conference_id, Long author_id) {
        this.abstract_id = abstract_id;
        this.document = document;
        this.conference_id = conference_id;
        this.author_id = author_id;
    }

    public Long getConference_id() {
        return conference_id;
    }

    public void setConference_id(Long conference_id) {
        this.conference_id = conference_id;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Paper(Long abstract_id) {
        this.abstract_id = abstract_id;
    }

    public Long getAbstract_id() {
        return abstract_id;
    }

    public void setAbstract_id(Long abstract_id) {
        this.abstract_id = abstract_id;
    }



    @Override
    public String toString() {
        return "Paper{" +
                "abstract_id=" + abstract_id +
                '}';
    }
}
