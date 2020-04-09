package repository;

import domain.AccountEntity;
import domain.AuthorEntity;
import domain.AuthorProposalEntity;
import domain.AuthorProposalEntityPK;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.Optional;

public class RepositoryAuthorProposal implements RepositoryInterface<AuthorProposalEntity, AuthorProposalEntityPK> {
    public RepositoryAuthorProposal() {
    }

    @Override
    public ArrayList<AuthorProposalEntity> findAll() {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from AuthorProposalEntity ");
        Object[] objects = query.list().toArray();
        ArrayList<AuthorProposalEntity> authorProposalEntities = new ArrayList<>();
        for (Object object : objects) {
            authorProposalEntities.add((AuthorProposalEntity) object);
        }
        session.close();
        return authorProposalEntities;
    }

    @Override
    public Optional<AuthorProposalEntity> findOne(AuthorProposalEntityPK id) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from AuthorProposalEntity A where A.proposalId="+id.getProposalId()+" and A.authorId="+id.getAuthorId());
        Object object = query.getSingleResult();
        return Optional.of( (AuthorProposalEntity) object);
    }

    @Override
    public void save(AuthorProposalEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(AuthorProposalEntityPK id) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.delete((AuthorProposalEntity)this.findOne(id).get());
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(AuthorProposalEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }
}
