package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PublishedPaperDto extends BaseDto {
    private String content;
    private Long conf_id;
    private Long author_id;
    private Long abstract_id;
    private Long section_id;
    private String paper_name;
    private String abstract_content;
    private String author_name;
}

