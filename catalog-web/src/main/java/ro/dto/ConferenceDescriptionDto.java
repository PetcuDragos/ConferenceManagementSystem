package ro.dto;
import lombok.NoArgsConstructor;
import ro.domain.Conference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ConferenceDescriptionDto implements Serializable {
    String name;
    MyConferenceDto conference;
    String chairName;
    String co_chairName;
}
