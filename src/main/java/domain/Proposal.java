package domain;

import javax.persistence.*;

@Entity
public class Proposal extends BaseEntity<Integer>{
    private String keywords;
    private String topic;
    private String abstractPaper;
    private String fullPaper;

    public Proposal() {
    }

    public Proposal(String keywords, String topic, String abstractPaper, String fullPaper) {
        this.keywords = keywords;
        this.topic = topic;
        this.abstractPaper = abstractPaper;
        this.fullPaper = fullPaper;
    }

    public Proposal(int id, String keywords, String topic, String abstractPaper, String fullPaper) {
        this.keywords = keywords;
        this.topic = topic;
        this.abstractPaper = abstractPaper;
        this.fullPaper = fullPaper;
        this.setId(id);
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAbstractPaper() {
        return abstractPaper;
    }

    public void setAbstractPaper(String abstractPaper) {
        this.abstractPaper = abstractPaper;
    }

    public String getFullPaper() {
        return fullPaper;
    }

    public void setFullPaper(String fullPaper) {
        this.fullPaper = fullPaper;
    }

    @Override
    public String toString() {
        return "Proposal{" +
                "id='" + this.getId() + '\'' +
                "keywords='" + keywords + '\'' +
                ", topic='" + topic + '\'' +
                ", abstractPaper='" + abstractPaper + '\'' +
                ", fullPaper='" + fullPaper + '\'' +
                '}';
    }
}
