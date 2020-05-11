package ubbproject.domain;

import javax.persistence.Entity;

@Entity
public class State extends BaseEntity<Long> {
    private Long account_id;

    public State(Long account_id) {
        this.account_id = account_id;
    }

    public State() {
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    @Override
    public String toString() {
        return "State{" +
                "account_id=" + account_id +
                '}';
    }
}
