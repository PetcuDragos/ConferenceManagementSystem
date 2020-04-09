package domain;

import javax.persistence.*;

@Entity
@Table(name = "PresentationRole", schema = "dbo", catalog = "conference")
public class PresentationRoleEntity {
    private int prRoleId;
    private String description;

    @Id
    @Column(name = "PrRoleID", nullable = false)
    public int getPrRoleId() {
        return prRoleId;
    }

    public void setPrRoleId(int prRoleId) {
        this.prRoleId = prRoleId;
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

        PresentationRoleEntity that = (PresentationRoleEntity) o;

        if (prRoleId != that.prRoleId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prRoleId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
