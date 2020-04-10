package repository;

import domain.PresentationEntity;
import domain.ProposalReviewEntity;
import domain.ProposalReviewEntityPK;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.Optional;

public class RepositoryProposalReview implements RepositoryInterface<ProposalReviewEntity, ProposalReviewEntityPK> {
    @Override
    public ArrayList<ProposalReviewEntity> findAll() {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from ProposalReviewEntity");
        Object[] objects = query.list().toArray();
        ArrayList<ProposalReviewEntity> proposalReviews = new ArrayList<>();
        for (Object object : objects) {
            proposalReviews.add((ProposalReviewEntity) object);
        }
        session.close();
        return proposalReviews;
    }

    @Override
    public Optional<ProposalReviewEntity> findOne(ProposalReviewEntityPK primaryKey) {
        return Optional.empty();
        // TODO: implement this for composite PK
    }

    @Override
    public void save(ProposalReviewEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(ProposalReviewEntityPK primaryKey) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.delete((ProposalReviewEntity)this.findOne(primaryKey).get());
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(ProposalReviewEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }
}
