package repository;

import domain.PresentationEntity;
import domain.ProposalEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.Optional;

public class RepositoryProposal implements RepositoryInterface<ProposalEntity, Integer> {
    @Override
    public ArrayList<ProposalEntity> findAll() {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from ProposalEntity");
        Object[] objects = query.list().toArray();
        ArrayList<ProposalEntity> proposals = new ArrayList<>();
        for (Object object : objects) {
            proposals.add((ProposalEntity) object);
        }
        session.close();
        return proposals;
    }

    @Override
    public Optional<ProposalEntity> findOne(Integer primaryKey) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from ProposalEntity P where P.proposalId="+primaryKey);
        Object object = query.getSingleResult();
        return Optional.of( (ProposalEntity) object);
    }

    @Override
    public void save(ProposalEntity entity) {
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
        session.delete((ProposalEntity)this.findOne(primaryKey).get());
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(ProposalEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }
}
