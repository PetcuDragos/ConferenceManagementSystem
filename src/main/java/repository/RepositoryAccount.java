package repository;

import domain.AccountEntity;
import domain.AuthorEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.Optional;

public class RepositoryAccount implements RepositoryInterface<AccountEntity, Integer> {
    public RepositoryAccount() {
    }

    @Override
    public ArrayList<AccountEntity> findAll() {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from AccountEntity ");
        Object[] objects = query.list().toArray();
        ArrayList<AccountEntity> accounts = new ArrayList<>();
        for (Object object : objects) {
            accounts.add((AccountEntity) object);
        }
        session.close();
        return accounts;
    }

    @Override
    public Optional<AccountEntity> findOne(Integer id) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        Query query =  session.createQuery("from AccountEntity A where A.accountId="+id);
        Object object = query.getSingleResult();
        return Optional.of( (AccountEntity) object);
    }

    @Override
    public void save(AccountEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Integer id) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.delete((AccountEntity)this.findOne(id).get());
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(AccountEntity entity) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        Session session = hibernateUtils.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }
}
