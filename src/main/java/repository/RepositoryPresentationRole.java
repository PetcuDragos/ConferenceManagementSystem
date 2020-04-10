package repository;

import domain.PresentationEntity;
import domain.PresentationRoleEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.Optional;

public class RepositoryPresentationRole implements RepositoryInterface<PresentationRoleEntity, Integer> {
    @Override
    public ArrayList<PresentationRoleEntity> findAll() {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from PresentationRoleEntity");
        Object[] objects = query.list().toArray();
        ArrayList<PresentationRoleEntity> roles = new ArrayList<>();
        for (Object object : objects) {
            roles.add((PresentationRoleEntity) object);
        }
        session.close();
        return roles;
    }

    @Override
    public Optional<PresentationRoleEntity> findOne(Integer primaryKey) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from PresentationRoleEntity P where P.prRoleId"+primaryKey);
        Object object = query.getSingleResult();
        return Optional.of( (PresentationRoleEntity) object);
    }

    @Override
    public void save(PresentationRoleEntity entity) {
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
        session.delete((PresentationRoleEntity)this.findOne(primaryKey).get());
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(PresentationRoleEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }
}
