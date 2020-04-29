package ubbproject.domain;

import javax.persistence.Entity;

@Entity
public class Author extends BaseEntity<Integer>{
    private String fullName;
    private String affiliation;
    private String email;

    public Author(String fullName, String affiliation, String email) {
        this.fullName = fullName;
        this.affiliation = affiliation;
        this.email = email;
    }

    public Author() {
    }

    public Author(int id, String fullName, String affiliation, String email) {
        this.fullName = fullName;
        this.affiliation = affiliation;
        this.email = email;
        this.setId(id);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + this.getId() + '\'' +
                "fullName='" + fullName + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
