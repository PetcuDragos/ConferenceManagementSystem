package repository;

import org.hibernate.type.EntityType;

import java.util.ArrayList;
import java.util.Optional;

public interface RepositoryInterface<T> {
    Iterable<T> findAll();
    Optional<T> findOne(int id);
    void save(T entity);
    void delete(int id);
    void update(T entity);
}
