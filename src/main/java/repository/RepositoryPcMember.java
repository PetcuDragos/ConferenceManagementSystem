package repository;

import domain.ParticipantEntity;
import domain.PcMemberEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.Optional;

public class RepositoryPcMember implements RepositoryInterface<PcMemberEntity, Integer> {
    public RepositoryPcMember() {
    }

    @Override
    public ArrayList<PcMemberEntity> findAll() {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from PcMemberEntity ");
        Object[] objects = query.list().toArray();
        ArrayList<PcMemberEntity> pcMemberEntities = new ArrayList<>();
        for (Object object : objects) {
            pcMemberEntities.add((PcMemberEntity) object);
        }
        session.close();
        return pcMemberEntities;
    }

    @Override
    public Optional<PcMemberEntity> findOne(Integer primaryKey) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from PcMemberEntity A where A.pcMemberId="+primaryKey);
        Object object = query.getSingleResult();
        return Optional.of( (PcMemberEntity) object);
    }

    @Override
    public void save(PcMemberEntity entity) {
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
        session.delete((PcMemberEntity)this.findOne(primaryKey).get());
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(PcMemberEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }
}
