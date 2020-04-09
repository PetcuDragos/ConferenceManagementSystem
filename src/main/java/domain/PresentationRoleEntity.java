package domain;

import javax.persistence.*;

@Entity
@Table(name = "PresentationRole", schema = "dbo", catalog = "conference")
public class PresentationRoleEntity {
    private Integer prRoleId;
    private String description;

    @Id
    @Column(name = "PrRoleID")
    public Integer getPrRoleId() {
        return prRoleId;
    }

    public void setPrRoleId(Integer prRoleId) {
        this.prRoleId = prRoleId;
    }

    @Basic
    @Column(name = "Description")
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

        if (prRoleId != null ? !prRoleId.equals(that.prRoleId) : that.prRoleId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prRoleId != null ? prRoleId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
