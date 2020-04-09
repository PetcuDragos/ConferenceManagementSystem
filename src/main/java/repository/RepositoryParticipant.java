package repository;

import domain.AuthorEntity;
import domain.ParticipantEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.Optional;

public class RepositoryParticipant implements RepositoryInterface<ParticipantEntity, Integer> {
    public RepositoryParticipant() {
    }

    @Override
    public ArrayList<ParticipantEntity> findAll() {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from ParticipantEntity ");
        Object[] objects = query.list().toArray();
        ArrayList<ParticipantEntity> participantEntities = new ArrayList<>();
        for (Object object : objects) {
            participantEntities.add((ParticipantEntity) object);
        }
        session.close();
        return participantEntities;
    }

    @Override
    public Optional<ParticipantEntity> findOne(Integer primaryKey) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from ParticipantEntity A where A.participantId="+primaryKey);
        Object object = query.getSingleResult();
        return Optional.of( (ParticipantEntity) object);
    }

    @Override
    public void save(ParticipantEntity entity) {
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
        session.delete((ParticipantEntity)this.findOne(primaryKey).get());
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(ParticipantEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }
}
