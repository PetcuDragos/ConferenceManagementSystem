package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.domain.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewEvaluationDto {
    private String conference_name;
    private Long abstract_id;
    private String content;
    private Integer result;
    private String username;
    private Date date;
}
