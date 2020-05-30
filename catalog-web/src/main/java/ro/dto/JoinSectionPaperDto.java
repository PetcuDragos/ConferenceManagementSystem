package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinSectionPaperDto implements Serializable {
    private Long abstract_id;
    private String section_name;
    private String conference_name;
    private String username;
}
