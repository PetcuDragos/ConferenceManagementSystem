package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MemberDto extends BaseDto {
    private String fullname;
    private String username;
    private String email;
    private String affiliation;
    private String webpage;
}
