package GroupA.services;

import GroupA.entities.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher savePublisher(Publisher publisher);
    Publisher getPublisherById(Long id);
    List<Publisher> getAllPublishers();
    void updatePublisher(Long id,Publisher publisher);
    void deletePublisherByName(String name);
}
