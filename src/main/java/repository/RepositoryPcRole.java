package repository;

import domain.PcMemberEntity;
import domain.PcRoleEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.Optional;

public class RepositoryPcRole implements RepositoryInterface<PcRoleEntity,Integer> {
    public RepositoryPcRole() {
    }

    @Override
    public ArrayList<PcRoleEntity> findAll() {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from PcRoleEntity ");
        Object[] objects = query.list().toArray();
        ArrayList<PcRoleEntity> pcRoleEntities = new ArrayList<>();
        for (Object object : objects) {
            pcRoleEntities.add((PcRoleEntity) object);
        }
        session.close();
        return pcRoleEntities;
    }

    @Override
    public Optional<PcRoleEntity> findOne(Integer primaryKey) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from PcRoleEntity A where A.pcRoleId="+primaryKey);
        Object object = query.getSingleResult();
        return Optional.of( (PcRoleEntity) object);
    }

    @Override
    public void save(PcRoleEntity entity) {
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
        session.delete((PcRoleEntity)this.findOne(primaryKey).get());
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(PcRoleEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }
}
