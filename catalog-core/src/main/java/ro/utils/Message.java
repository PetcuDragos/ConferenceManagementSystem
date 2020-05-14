package ro.utils;

import lombok.Data;
import ro.domain.BaseEntity;

import java.io.Serializable;

@Data
public class Message<T> implements Serializable {
    private T entity;
    private String error;

    public Message(T entity, String error){
        this.entity = entity;
        this.error = error;
    }

}
