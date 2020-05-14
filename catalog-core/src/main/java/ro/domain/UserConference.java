package ro.domain;

import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@ToString
@EqualsAndHashCode(callSuper = true)
public class UserConference extends BaseEntity{
    private Long conference_id;
    private Long user_id;
}
