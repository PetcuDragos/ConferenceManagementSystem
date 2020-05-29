package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    boolean joined;
}
