package GroupA.repo.impl;

import GroupA.config.HibernateConfig;
import GroupA.entities.Reader;
import GroupA.repo.ReaderRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ReaderRepoImpl implements ReaderRepo {
    private final EntityManagerFactory entityManager = HibernateConfig.getEntityManager();

    @Override
    public String saveReader(Reader reader) {
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        entityManager1.persist(reader);
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return reader.getName()+" "+"is saved...";
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        Reader reader1 = entityManager1.find(Reader.class, id);
        reader1.setName(reader.getName());
        reader1.setAge(reader.getAge());
        reader1.setEmail(reader.getEmail());
        entityManager1.merge(reader1);
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return reader1;
    }

    @Override
    public Reader getReaderByBookId() {
        return null;
    }

    @Override
    public String deleteReaderById(Long id) {
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        Reader reader = entityManager1.find(Reader.class, id);
        entityManager1.remove(reader);
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return reader.getName()+" "+"is deleted...";
    }

    @Override
    public void getReadersByAuthorId() {

    }
}
