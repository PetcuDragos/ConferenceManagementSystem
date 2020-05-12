package ubbproject.domain;

import javax.persistence.Entity;

@Entity
public class MyUser extends BaseEntity<Long> {

    private String fullName;
    private String affiliation;
    private String email;
    private String username;
    private String password;
    private String web_page;


    public MyUser(String username, String password, String email, String fullName, String affiliation, String web_page) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.affiliation = affiliation;
        this.web_page = web_page;
    }

    public MyUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = null;
        this.affiliation = null;
        this.web_page = null;
    }

    public MyUser() {
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

    public String getWeb_page() {
        return web_page;
    }

    public void setWeb_page(String web_page) {
        this.web_page = web_page;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", web_page='" + web_page + '\'' +
                '}';
    }
}
