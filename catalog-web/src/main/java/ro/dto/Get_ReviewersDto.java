package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Get_ReviewersDto implements Serializable {
    private String conference_name;
    private Long abstract_id;
}
