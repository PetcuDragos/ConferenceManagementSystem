package repository;

import domain.PresentationEntity;
import domain.PresentationParticipantEntity;
import domain.PresentationParticipantEntityPK;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.Optional;

public class RepositoryPresentationParticipant implements RepositoryInterface<PresentationParticipantEntity, PresentationParticipantEntityPK> {
    @Override
    public ArrayList<PresentationParticipantEntity> findAll() {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from PresentationParticipantEntity");
        Object[] objects = query.list().toArray();
        ArrayList<PresentationParticipantEntity> presentations = new ArrayList<>();
        for (Object object : objects) {
            presentations.add((PresentationParticipantEntity) object);
        }
        session.close();
        return presentations;
    }

    @Override
    public Optional<PresentationParticipantEntity> findOne(PresentationParticipantEntityPK primaryKey) {
        return Optional.empty();
        // TODO: see how to solve the issue for composite PK
    }

    @Override
    public void save(PresentationParticipantEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(PresentationParticipantEntityPK primaryKey) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.delete((PresentationParticipantEntity)this.findOne(primaryKey).get());
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(PresentationParticipantEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }
}
