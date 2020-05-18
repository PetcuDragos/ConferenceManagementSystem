package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ro.domain.Abstract;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AbstractDto implements Serializable {
    private Abstract entity;
    private String authorName;
}
