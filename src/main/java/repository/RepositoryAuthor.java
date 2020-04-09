package repository;

import domain.AuthorEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.Optional;

public class RepositoryAuthor implements RepositoryInterface<AuthorEntity> {

    public RepositoryAuthor() {}

    @Override
    public ArrayList<AuthorEntity> findAll(){
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from AuthorEntity ");
        Object[] objects = query.list().toArray();
        ArrayList<AuthorEntity> authors = new ArrayList<>();
        for (Object object : objects) {
            authors.add((AuthorEntity) object);
        }
        session.close();
        return authors;
    }

    @Override
    public Optional<AuthorEntity> findOne(int id) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from AuthorEntity A where A.authorId="+id);
        Object object = query.getSingleResult();
        return Optional.of( (AuthorEntity) object);
    }

    @Override
    public void save(AuthorEntity authorEntity){
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.save(authorEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.delete((AuthorEntity)this.findOne(id).get());
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(AuthorEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }
}
