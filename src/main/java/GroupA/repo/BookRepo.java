package GroupA.repo;

import GroupA.entities.Author;
import GroupA.entities.Book;

public interface BookRepo {
 String saveBook(Book book,Long id); //Book сакталып жатканда кандайдыр бир авторго тиешелуу болуп сакталуусу керек
 void updateBookAuthor(Long id, Author author);
 void getBookAndPublisherByBookId(); //Бир Id ге тиешелуу book тун маалыматтары жана ага тиешелуу издательствосу чыксын
 void deleteBookByAuthorId(Long authorId);
}
