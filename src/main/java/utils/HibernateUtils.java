package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private SessionFactory sessionFactory;

    public HibernateUtils() {

        Configuration configuration = new Configuration();
        configuration.configure();

        this.sessionFactory=configuration.buildSessionFactory();
    }

    public Session getSession(){
        return this.sessionFactory.openSession();
    }
}
