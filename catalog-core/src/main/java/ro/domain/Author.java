package ro.domain;

import javax.persistence.Entity;

@Entity
public class Author extends BaseEntity{
    private Long conference_id;
    private Long myuser_id;

    public Author() {
    }

    public Author(Long myuser_id, Long conference_id){
        this.conference_id = conference_id;
        this.myuser_id = myuser_id;
    }

    public Long getConference_id() {
        return conference_id;
    }

    public void setConference_id(Long conference_id) {
        this.conference_id = conference_id;
    }

    public Long getMyuser_id() {
        return myuser_id;
    }

    public void setMyuser_id(Long user_id) {
        this.myuser_id = user_id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "conference_id=" + conference_id +
                ", user_id=" + myuser_id +
                '}';
    }
}
