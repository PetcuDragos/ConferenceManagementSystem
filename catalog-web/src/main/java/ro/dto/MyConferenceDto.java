package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.domain.Date;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyConferenceDto implements Serializable {
    private Long id;
    private String name;
    private Date abstractDeadline;
    private Date paperDeadline;
    private Date bidDeadline;
    private Date reviewDeadline;
    private Date startingDate;
    private Date endingDate;
    private Long chair_id;
    private Long co_chair_id;
}
