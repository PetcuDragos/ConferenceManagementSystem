package ubbproject.domain;

import javax.persistence.*;

@Entity
public class PcMember extends BaseEntity<Integer>{
    private int accountId;
    private int pcRoleId;
    private String website;

    public PcMember() {
    }

    public PcMember(int accountId, int pcRoleId, String website) {
        this.accountId = accountId;
        this.pcRoleId = pcRoleId;
        this.website = website;
    }

    public PcMember(int id, int accountId, int pcRoleId, String website) {
        this.accountId = accountId;
        this.pcRoleId = pcRoleId;
        this.website = website;
        this.setId(id);
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getPcRoleId() {
        return pcRoleId;
    }

    public void setPcRoleId(int PCRoleId) {
        this.pcRoleId = PCRoleId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "PcMember{" +
                "Id=" + this.getId() +
                "AccountId=" + accountId +
                ", PCRoleId=" + pcRoleId +
                ", website='" + website + '\'' +
                '}';
    }
}
