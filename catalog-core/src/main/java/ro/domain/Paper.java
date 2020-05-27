package ro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paper extends BaseEntity{

    private Long abstract_id;
    private String document;
    private Long conference_id;
    private Long author_id;
    private int reEvaluated;

    public Paper(Long abstract_id, String document, Long conference_id, Long author_id) {
        this.abstract_id = abstract_id;
        this.document = document;
        this.conference_id = conference_id;
        this.author_id = author_id;
        this.reEvaluated = 0;
    }
}
