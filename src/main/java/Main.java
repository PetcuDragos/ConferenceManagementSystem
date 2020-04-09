import domain.AuthorEntity;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import repository.RepositoryAuthor;
import repository.RepositoryInterface;

import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hi");
        /*
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();

        sessionFactory=configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for(EntityType<?> entityType: metamodel.getEntities())
            {
                String entityName=entityType.getName();
                Query query = session.createQuery("from "+entityName);
                for(Object o:query.list()){
                    System.out.println(" "+o);
                }
            }
        }
        catch (Exception e){
            System.out.println("exc: "+e.toString());
        }
        session.close();

         */

        RepositoryInterface repositoryAuthor = new RepositoryAuthor();
        AuthorEntity author = new AuthorEntity();
        author.setAuthorId(2);
        author.setFullName("Iuliana");
        author.setAffiliation("FMI");
        author.setEmail("iuliana@scs.ro");
        repositoryAuthor.save(author);

        ArrayList<AuthorEntity> authorEntities = (ArrayList<AuthorEntity>) repositoryAuthor.findAll();
        for (AuthorEntity a: authorEntities) {
            System.out.println(a);
        }
    }
}
