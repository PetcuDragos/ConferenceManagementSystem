package ro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewEvaluation extends BaseEntity {
    private Long pc_id;
    private Long paper_id;
    private int result;
    private java.sql.Date date;
    @Column(length=1000)
    private String content;

}
