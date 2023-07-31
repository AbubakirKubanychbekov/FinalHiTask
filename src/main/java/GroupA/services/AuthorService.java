package GroupA.services;

import GroupA.entities.Author;

import java.util.List;

public interface AuthorService {
    String saveAuthor(Author author);
    String updateAuthor(Long id, Author author);
    Author getAuthorById(Long id);
    List<Author> getAuthorsByPublisherId(Long id);
    String deleteAuthorById(Long id);
    void assignAuthorToPublisher(Long id,Long publisherId);
}
