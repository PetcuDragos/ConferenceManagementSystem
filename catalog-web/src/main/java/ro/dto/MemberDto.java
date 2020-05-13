package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class MemberDto extends BaseDto {
    private String fullname;
    private String username;
    private String email;
    private String affiliation;
    private String webpage;
}
