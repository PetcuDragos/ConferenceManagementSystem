package ro.domain;

import javax.persistence.*;

@Entity
public class Abstract extends BaseEntity<Long>{
    private String keywords;
    private String topics;
    private String name;
    private String additionalAuthors;
    private String content;
    private Long author_id;
    private Long conference_id;

    public Abstract() {
    }

    public Abstract(String keywords, String topics, String name, String additionalAuthors, String content, Long author_id, Long conference_id) {
        this.keywords = keywords;
        this.topics = topics;
        this.name = name;
        this.additionalAuthors = additionalAuthors;
        this.content = content;
        this.author_id = author_id;
        this.conference_id = conference_id;
    }

    public Long getConference_id() {
        return conference_id;
    }

    public void setConference_id(Long conference_id) {
        this.conference_id = conference_id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdditionalAuthors() {
        return additionalAuthors;
    }

    public void setAdditionalAuthors(String additionalAuthors) {
        this.additionalAuthors = additionalAuthors;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "Abstract{" +
                "keywords='" + keywords + '\'' +
                ", topics='" + topics + '\'' +
                ", name='" + name + '\'' +
                ", additionalAuthors='" + additionalAuthors + '\'' +
                ", content='" + content + '\'' +
                ", author_id=" + author_id +
                '}';
    }
}
