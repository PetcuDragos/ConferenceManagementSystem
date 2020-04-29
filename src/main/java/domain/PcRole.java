package domain;

import javax.persistence.*;

@Entity
public class PcRole extends BaseEntity<Integer>{
    private String description;

    public PcRole() {
    }

    public PcRole(String description) {
        this.description = description;
    }

    public PcRole(int id, String description) {
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
        return "PcRoleEntity{" +
                "Id=" + this.getId() +
                ", description='" + description + '\'' +
                '}';
    }
}
