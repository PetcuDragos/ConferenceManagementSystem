package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ro.domain.Abstract;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AbstractDto implements Serializable {
    private Long abstract_id;
    private Abstract entity;
    private String authorName;
}
