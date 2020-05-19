package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class JoinConferenceDto {
    private String username;
    private long conferenceId;
}
