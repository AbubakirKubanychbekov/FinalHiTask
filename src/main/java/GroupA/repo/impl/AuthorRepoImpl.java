package GroupA.repo.impl;

import GroupA.config.HibernateConfig;
import GroupA.entities.Author;
import GroupA.entities.Publisher;
import GroupA.repo.AuthorRepo;
import GroupA.repo.PublisherRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class AuthorRepoImpl implements AuthorRepo {
    private final EntityManagerFactory entityManager = HibernateConfig.getEntityManager();

    @Override
    public String saveAuthor(Author author) {
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        entityManager1.persist(author);
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return author.getFirstName()+" "+"is saved...";
    }

    @Override
    public String updateAuthor(Long id, Author author) {
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        Author author1 = entityManager1.find(Author.class, id);
        author1.setFirstName(author.getFirstName());
        author1.setLastName(author.getLastName());
        author1.setEmail(author.getEmail());
        author1.setDateOfBirth(author.getDateOfBirth());
        author1.setCountry(author.getCountry());
        author1.setGender(author.getGender());
        entityManager1.merge(author1);
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return author1.getFirstName()+" "+"is successfully update";
    }

    @Override
    public Author getAuthorById(Long id) {
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        Author author = entityManager1.find(Author.class, id);
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return author;
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long id) {
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        Publisher publisher = entityManager1.find(Publisher.class, id);
        List<Author> authors = publisher.getAuthors();
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return authors;
    }

    @Override
    public String deleteAuthorById(Long id) {
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        Author author = entityManager1.find(Author.class, id);
        entityManager1.remove(author);
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return author.getFirstName()+" "+"is deleted";
    }

    @Override
    public void assignAuthorToPublisher(Long id, Long publisherId) {

    }
}
