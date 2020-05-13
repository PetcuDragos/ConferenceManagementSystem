package ro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@ToString
public class UserConference extends BaseEntity{
    private Long conference_id;
    private Long user_id;
}
