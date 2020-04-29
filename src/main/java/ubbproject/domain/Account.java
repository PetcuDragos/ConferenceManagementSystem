package ubbproject.domain;

import javax.persistence.Entity;

@Entity
public class Account extends BaseEntity<Integer>{

    private String fullName;
    private String affiliation;
    private String email;
    private String username;
    private String password;


    public Account(String fullName, String affiliation, String email, String username, String password) {
        this.fullName = fullName;
        this.affiliation = affiliation;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Account() {
    }

    public Account(int id, String fullName, String affiliation, String email, String username, String password) {
        this.fullName = fullName;
        this.affiliation = affiliation;
        this.email = email;
        this.username = username;
        this.password = password;
        this.setId(id);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + this.getId() + '\'' +
                "fullName='" + fullName + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
