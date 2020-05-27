package ro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ro.domain.Abstract;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class AbstractDto implements Serializable {
    private Abstract entity;
    private String authorName;
    private boolean bidded;
    private boolean reviewed;
    private String url;
    private boolean canReview;
    private List<String> reviewers;
    private List<SectionDto> sections;
}
