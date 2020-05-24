package ro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewEvaluation extends BaseEntity {
    private Long pc_id;
    private Long paper_id;
    private int result;
    private java.sql.Date date;
    private String content;


}
