package GroupA.services.impl;

import GroupA.entities.Publisher;
import GroupA.repo.PublisherRepo;
import GroupA.repo.impl.PublisherRepoImpl;
import GroupA.services.PublisherService;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepo publisherRepo=new PublisherRepoImpl();
    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepo.savePublisher(publisher);
    }

    @Override
    public Publisher getPublisherById(Long id) {
     return publisherRepo.getPublisherById(id);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepo.getAllPublishers();
    }

    @Override
    public void updatePublisher(Long id, Publisher publisher) {
   publisherRepo.updatePublisher(id,publisher);
    }

    @Override
    public void deletePublisherByName(String name) {
  publisherRepo.deletePublisherByName(name);
    }
}
