package ro.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewsletterDto implements Serializable {
    private String name;
    private String email;
    private Boolean dailyNewsletter;
}
