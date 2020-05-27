package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddSectionDto {
    String conference_name;
    String pc_username;
    String section_name;
}
