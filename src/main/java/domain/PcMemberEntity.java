package domain;

import javax.persistence.*;

@Entity
@Table(name = "PCMember", schema = "dbo", catalog = "conference")
public class PcMemberEntity {
    private Integer pcMemberId;
    private String website;

    @Id
    @Column(name = "PCMemberID")
    public Integer getPcMemberId() {
        return pcMemberId;
    }

    public void setPcMemberId(Integer pcMemberId) {
        this.pcMemberId = pcMemberId;
    }

    @Basic
    @Column(name = "Website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PcMemberEntity that = (PcMemberEntity) o;

        if (pcMemberId != null ? !pcMemberId.equals(that.pcMemberId) : that.pcMemberId != null) return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pcMemberId != null ? pcMemberId.hashCode() : 0;
        result = 31 * result + (website != null ? website.hashCode() : 0);
        return result;
    }
}
