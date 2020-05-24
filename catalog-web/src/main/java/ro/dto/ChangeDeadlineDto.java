package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.domain.Date;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeDeadlineDto implements Serializable {
    private String conference;
    private Date abstract_deadline;
    private Date paper_deadline;
    private Date bidding_deadline;
    private Date review_deadline;
    private Date ending_date;
}
