package domain;

import javax.persistence.Entity;

@Entity
public class Participant extends BaseEntity<Integer>{

    private int accountId;
    private int authorId;

    public Participant(int accountId, int authorId) {
        this.accountId = accountId;
        this.authorId = authorId;
    }

    public Participant(int id, int accountId, int authorId) {
        this.accountId = accountId;
        this.authorId = authorId;
        this.setId(id);
    }

    public Participant() {
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "Id=" + this.getId() +
                "AccountId=" + accountId +
                ", AuthorId=" + authorId +
                '}';
    }
}
