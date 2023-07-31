package GroupA.services.impl;

import GroupA.entities.Author;
import GroupA.repo.AuthorRepo;
import GroupA.repo.impl.AuthorRepoImpl;
import GroupA.services.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    AuthorRepo authorRepo=new AuthorRepoImpl();

    @Override
    public String saveAuthor(Author author) {
        return authorRepo.saveAuthor(author);
    }

    @Override
    public String updateAuthor(Long id, Author author) {
        return authorRepo.updateAuthor(id,author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepo.getAuthorById(id);
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long id) {
        return authorRepo.getAuthorsByPublisherId(id);
    }

    @Override
    public String deleteAuthorById(Long id) {
        return authorRepo.deleteAuthorById(id);
    }

    @Override
    public void assignAuthorToPublisher(Long id, Long publisherId) {

    }
}
