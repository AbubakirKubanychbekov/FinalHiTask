package GroupA.config;

import GroupA.entities.Author;
import GroupA.entities.Book;
import GroupA.entities.Publisher;
import GroupA.entities.Reader;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {

    public static EntityManagerFactory getEntityManager() {
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        properties.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/FinalHi");
        properties.setProperty(Environment.USER, "postgres");
        properties.setProperty(Environment.PASS, "postgres");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Publisher.class);
        configuration.addAnnotatedClass(Reader.class);
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }
}