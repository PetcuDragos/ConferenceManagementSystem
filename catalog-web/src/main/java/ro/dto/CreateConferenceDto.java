package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.domain.Date;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateConferenceDto implements Serializable {
    private String conference_name;
    private String chair_username;
    private String co_chair_username;
    private Date starting_date;
    private Date ending_date;
    private Date abstract_deadline;
    private Date paper_deadline;
    private Date bidding_deadline;
    private Date review_deadline;
    private Date reEval_deadline;
    private Date submissionDate;
}
