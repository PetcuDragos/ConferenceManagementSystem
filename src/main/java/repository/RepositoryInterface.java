package repository;

import org.hibernate.type.EntityType;

import java.util.ArrayList;
import java.util.Optional;

public interface RepositoryInterface<T,K> {
    ArrayList<T> findAll();
    Optional<T> findOne(K primaryKey);
    void save(T entity);
    void delete(K primaryKey);
    void update(T entity);
}
