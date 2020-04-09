package domain;

import javax.persistence.*;

@Entity
@Table(name = "PCRole", schema = "dbo", catalog = "conference")
public class PcRoleEntity {
    private int pcRoleId;
    private String description;

    @Id
    @Column(name = "PCRoleID", nullable = false)
    public int getPcRoleId() {
        return pcRoleId;
    }

    public void setPcRoleId(int pcRoleId) {
        this.pcRoleId = pcRoleId;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PcRoleEntity that = (PcRoleEntity) o;

        if (pcRoleId != that.pcRoleId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pcRoleId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
