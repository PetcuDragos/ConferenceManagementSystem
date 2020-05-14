package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PaperDto extends BaseDto {
    private String content;
    private Long conf_id;
    private Long author_id;
    private Long abstract_id;
    private Long section_id;
}
