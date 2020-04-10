package repository;

import domain.PresentationEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.Optional;

public class RepositoryPresentation implements RepositoryInterface<PresentationEntity, Integer>{
    public RepositoryPresentation(){

    }

    @Override
    public ArrayList<PresentationEntity> findAll() {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from PresentationEntity");
        Object[] objects = query.list().toArray();
        ArrayList<PresentationEntity> presentations = new ArrayList<>();
        for (Object object : objects) {
            presentations.add((PresentationEntity) object);
        }
        session.close();
        return presentations;
    }

    @Override
    public Optional<PresentationEntity> findOne(Integer primaryKey) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from PresentationEntity P where P.presentationId="+primaryKey);
        Object object = query.getSingleResult();
        return Optional.of( (PresentationEntity) object);
    }

    @Override
    public void save(PresentationEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Integer primaryKey) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.delete((PresentationEntity)this.findOne(primaryKey).get());
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(PresentationEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }
}
