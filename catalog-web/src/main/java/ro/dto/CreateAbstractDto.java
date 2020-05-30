package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAbstractDto implements Serializable {
    private String username;
    private String conference_name;
    private String title;
    private String content;
    private String keywords;
    private String topics;
    private String additional_authors;
    private Long id;
    private String url;
}
