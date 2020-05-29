package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@ToString
public class ConferenceDto implements Serializable {
    private String title;
    private String conferenceName;
}
