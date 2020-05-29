package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Add_ReviewerDto implements Serializable {
    private Long abstract_id;
    private Long pc_id;
}
