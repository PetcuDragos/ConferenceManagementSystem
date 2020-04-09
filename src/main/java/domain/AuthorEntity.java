package domain;


import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Author", schema = "dbo", catalog = "conference")
public class AuthorEntity {
    private int authorId;
    private String fullName;
    private String affiliation;
    private String email;

    @Id
    @Generated(value = GenerationTime.INSERT)
    @Column(name = "AuthorID", updatable = false, nullable = false)
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "FullName")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "Affiliation")
    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEntity that = (AuthorEntity) o;
        return authorId == that.authorId &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(affiliation, that.affiliation) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, fullName, affiliation, email);
    }

    @Override
    public String toString() {
        return "AuthorEntity{" +
                "authorId=" + authorId +
                ", fullName='" + fullName + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
