package ro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(uniqueConstraints = @UniqueConstraint(columnNames={"user_id"}))
@Entity
public class ScMember extends BaseEntity {

    @Column(name="user_id")
    private Long user_id;

    public ScMember(Long user_id) {
        this.user_id = user_id;
    }

    public ScMember() {
    }


    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "ScMember{" +
                "user_id=" + user_id +
                '}';
    }
}
