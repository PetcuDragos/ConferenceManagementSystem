package ubbproject.domain;

import javax.persistence.*;

@Entity
public class PresentationRole extends BaseEntity<Integer>{
    private String description;

    public PresentationRole() {
    }

    public PresentationRole(String description) {
        this.description = description;
    }

    public PresentationRole(int id, String description) {
        this.description = description;
        this.setId(id);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PresentationRoleEntity{" +
                "id=" + this.getId() +
                ", description='" + description + '\'' +
                '}';
    }
}
