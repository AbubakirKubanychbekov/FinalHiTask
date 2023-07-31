package GroupA.repo.impl;

import GroupA.config.HibernateConfig;
import GroupA.entities.Publisher;
import GroupA.repo.PublisherRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class PublisherRepoImpl implements PublisherRepo {
    private final EntityManagerFactory entityManager = HibernateConfig.getEntityManager();
    @Override
    public Publisher savePublisher(Publisher publisher) {
        EntityManager entityManager = this.entityManager.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public Publisher getPublisherById(Long id) {
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        Publisher publisher = entityManager1.find(Publisher.class, id);
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return publisher;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        List<Publisher> publishers1 = entityManager1.createQuery("select p from Publisher p", Publisher.class).getResultList();
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return publishers1;
    }

    @Override
    public void updatePublisher(Long id, Publisher publisher){
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        Publisher publisher1 = entityManager1.find(Publisher.class, id);
        publisher1.setName(publisher.getName());
        publisher1.setAddress(publisher.getAddress());
        entityManager1.merge(publisher1);
        entityManager1.getTransaction().commit();
        entityManager1.close();
    }

    @Override
    public void deletePublisherByName(String name) {
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        Publisher publisher = entityManager1.find(Publisher.class, name);
        entityManager1.remove(publisher);
        entityManager1.getTransaction().commit();
        entityManager1.close();
    }
}
