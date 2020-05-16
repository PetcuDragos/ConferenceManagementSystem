package ro.dto;
import ro.domain.Conference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString
public class ConferenceChairCoChairDto {
    String name;
    Conference conference;
    String chair;
    String co_chair;
}
