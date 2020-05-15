package ro.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProfilePageDto implements Serializable {
    private String username;
    private String fullName;
    private String email;
    private String affiliation;
    private String webpage;
}
