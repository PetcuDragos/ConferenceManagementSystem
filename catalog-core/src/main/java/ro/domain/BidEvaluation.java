package ro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BidEvaluation extends BaseEntity{

    private Long pc_id;
    private Long abstract_id;
    private int result;
    private java.sql.Date date;

}
