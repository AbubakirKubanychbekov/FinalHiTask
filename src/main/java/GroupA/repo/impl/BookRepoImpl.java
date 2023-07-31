package GroupA.repo.impl;

import GroupA.config.HibernateConfig;
import GroupA.entities.Author;
import GroupA.entities.Book;
import GroupA.repo.BookRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class BookRepoImpl implements BookRepo {
    private final EntityManagerFactory entityManager = HibernateConfig.getEntityManager();

    @Override
    public String saveBook(Book book, Long id) {
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        Author author = entityManager1.find(Author.class, id);
        book.setAuthor(author);
        entityManager1.persist(book);
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return "Book is saved";
    }

    @Override
    public void updateBookAuthor(Long id, Author author) {
        EntityManager entityManager1 = entityManager.createEntityManager();
    entityManager1.getTransaction().begin();
        Book book = entityManager1.find(Book.class, id);
        book.setAuthor(book.getAuthor());
        book.setName(book.getName());
        book.setCountry(book.getCountry());
        book.setPublishedYear(book.getPublishedYear());
        book.setPrice(book.getPrice());
        book.setGenre(book.getGenre());
        entityManager1.getTransaction().commit();
        entityManager1.close();
    }

    @Override
    public void getBookAndPublisherByBookId() {

    }

    @Override
    public void deleteBookByAuthorId(Long authorId) {
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        Author author = entityManager1.find(Author.class, authorId);
        entityManager1.remove(author);
        entityManager1.getTransaction().commit();
        entityManager1.close();

    }
}
