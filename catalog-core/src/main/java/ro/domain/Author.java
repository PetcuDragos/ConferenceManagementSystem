package ro.domain;

import javax.persistence.Entity;

@Entity
public class Author extends BaseEntity{
    private Long conference_id;
    private Long user_id;

    public Author() {
    }

    public Author(Long user_id,Long conference_id){
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
        return "Author{" +
                "conference_id=" + conference_id +
                ", user_id=" + user_id +
                '}';
    }
}
