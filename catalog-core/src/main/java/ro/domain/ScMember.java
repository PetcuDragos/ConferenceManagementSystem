package ro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(uniqueConstraints = @UniqueConstraint(columnNames={"myuser_id"}))
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScMember extends BaseEntity {

    @Column(name="myuser_id")
    private Long myuser_id;

}
