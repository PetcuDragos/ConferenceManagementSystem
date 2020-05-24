package ro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conference extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
    private java.sql.Date abstractDeadline;
    private java.sql.Date paperDeadline;
    private java.sql.Date bidDeadline;
    private java.sql.Date reviewDeadline;
    private java.sql.Date startingDate;
    private java.sql.Date endingDate;
    private Long chair_id;
    private Long co_chair_id;

}
