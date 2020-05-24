package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.domain.Date;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBidDto implements Serializable {
    private Long abstract_id;
    private Date date;
    private String pc_name;
    private Integer result;
}
