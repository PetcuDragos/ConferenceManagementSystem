package ro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(uniqueConstraints = @UniqueConstraint(columnNames={"user_id"}))
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScMember extends BaseEntity {

    @Column(name="user_id")
    private Long user_id;

}
