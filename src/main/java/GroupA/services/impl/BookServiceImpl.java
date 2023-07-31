package GroupA.services.impl;

import GroupA.entities.Author;
import GroupA.entities.Book;
import GroupA.repo.BookRepo;
import GroupA.repo.impl.BookRepoImpl;
import GroupA.services.BookService;

public class BookServiceImpl implements BookService {
    BookRepo bookRepo=new BookRepoImpl();
    @Override
    public String saveBook(Book book,Long id) {
        return bookRepo.saveBook( book, id);
    }

    @Override
    public void updateBookAuthor(Long id, Author author) {
        bookRepo.updateBookAuthor(id,author);

    }

    @Override
    public void getBookAndPublisherByBookId() {

    }

    @Override
    public void deleteBookByAuthorId(Long authorId) {
        bookRepo.deleteBookByAuthorId(authorId);

    }
}
