package ro.domain;

import javax.persistence.Entity;

@Entity
public class Newsletter extends BaseEntity {

    private String name;
    private String email;
    private Boolean dailyNewsletter;

    public Newsletter(String givenName, String givenEmail, Boolean givenDailyNewsletter)
    {
        this.name = givenName;
        this.email = givenEmail;
        this.dailyNewsletter = givenDailyNewsletter;
    }

    public Newsletter(){

    }

    public String getName() {
        return name;
    }

    public void setName(String givenName) {
        this.name = givenName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String givenEmail) {
        this.email = givenEmail;
    }

    public Boolean getDailyNewsletter() {
        return dailyNewsletter;
    }

    public void setDailyNewsletter(Boolean dailyNewsletter) {
        this.dailyNewsletter = dailyNewsletter;
    }

    @Override
    public String toString() {
        return "Newsletter{" +
                "name='" + this.name + '\'' +
                ", email='" + this.email + '\'' +
                '}';
    }

}
