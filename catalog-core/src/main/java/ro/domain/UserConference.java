package ro.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@ToString
@EqualsAndHashCode(callSuper = true)
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"conference_id","myuser_id"}))
public class UserConference extends BaseEntity{
    private Long conference_id;
    private Long myuser_id;
}
