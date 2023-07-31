package GroupA;

import GroupA.config.HibernateConfig;
import GroupA.entities.Author;
import GroupA.entities.Book;
import GroupA.entities.Publisher;
import GroupA.entities.Reader;
import GroupA.enums.Gender;
import GroupA.enums.Genre;
import GroupA.services.AuthorService;
import GroupA.services.BookService;
import GroupA.services.PublisherService;
import GroupA.services.ReaderService;
import GroupA.services.impl.AuthorServiceImpl;
import GroupA.services.impl.BookServiceImpl;
import GroupA.services.impl.PublisherServiceImpl;
import GroupA.services.impl.ReaderServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;



/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){

        HibernateConfig.getEntityManager();
        AuthorService authorService=new AuthorServiceImpl();
        BookService bookService=new BookServiceImpl();
        PublisherService publisherService=new PublisherServiceImpl();
        ReaderService readerService=new ReaderServiceImpl();

        while (true) {
            System.out.println("--- Publisher ---" +
                    "\n1.save" +
                    "\n2.getById" +
                    "\n3.getAll" +
                    "\n4.update" +
                    "\n5.delete" +
                    "\n --- Author ---" +
                    "\n6.save" +
                    "\n7.update" +
                    "\n8.findById" +
                    "\n9.getAuthorsByPublisherId" +
                    "\n10.deleteAuthorById" +
                    "\n --- Book ---" +
                    "\n11.save" +
                    "\n12.updateBookAuthor" +
                    "\n13.deleteBookByAuthorId" +
                    "\n--- Reader ---" +
                    "\n14.saveReader" +
                    "\n15.updateReader" +
                    "\n16.deleteReaderById");
            switch (new Scanner(System.in).nextInt()){
             case 1 -> {
                 System.out.println(publisherService.savePublisher(new Publisher("Raritet", "Chyi")));
                 System.out.println(publisherService.savePublisher(new Publisher("CityLife", "Kievskiy")));
                 System.out.println(publisherService.savePublisher(new Publisher("Golden page", "Baytik baatyr")));
             }case 2->{
                    System.out.println("Write id for find: ");
                    System.out.println(publisherService.getPublisherById(new Scanner(System.in).nextLong()));
                }case 3 ->{
                    publisherService.getAllPublishers().forEach(System.out::println);
                }case 4 ->{
                  publisherService.updatePublisher(2L,new Publisher("Tamga","Bokonbaeva"));
                }case 5->{
                 publisherService.deletePublisherByName("CityLife"); //?
                }case 6->{
                    System.out.println(authorService.saveAuthor(new Author("Chyngyz", "Aitmatov", "chyngyz@gmail.com", LocalDate.of(1928,12,9) , "Kyrgyzstan",Gender.MALE)));
                    System.out.println(authorService.saveAuthor(new Author("Robert", "Kiosaki", "robert@gmail.com", LocalDate.of(1970,1,1), "Japan",Gender.MALE)));
                    System.out.println(authorService.saveAuthor(new Author("Joanne", "Rowling", "rowling@gmail.com", LocalDate.of(1965,4,4), "USA",Gender.FEMALE)));
                }case 7->{
                    System.out.println(authorService.updateAuthor(2L, new Author("Maksim", "Gorkiy", "max@gmail.com", LocalDate.of(1985,4,5), "RUSSIA", Gender.MALE)));
                }case 8->{
                    System.out.println("Write id for find: ");
                    System.out.println(authorService.getAuthorById(new Scanner(System.in).nextLong()));
                }case 9->{
                    System.out.println(authorService.getAuthorsByPublisherId(2L));
                }case 10->{
                    System.out.println("Write id for delete: ");
                    System.out.println(authorService.deleteAuthorById(new Scanner(System.in).nextLong()));
                }case 11->{
//                  authorService.saveAuthor(new Author("Mikhail","Lomonosov","l@gmail.com",LocalDate.of(1890,2,9),"Russia",Gender.MALE));
                 bookService.saveBook(new Book("Harry Potter","USA", LocalDate.of(2002,9,9), BigDecimal.valueOf(2000), Genre.FANTASY),2L);
             }case 12->{
                 bookService.updateBookAuthor(2L,new Author("Abubakir","Kubanychbekov","a@gmail.com",LocalDate.of(1997,5,6),"Kyrgyzstan",Gender.MALE));
             }case 13->{
                  bookService.deleteBookByAuthorId(new Scanner(System.in).nextLong());
             }case 14->{
                    System.out.println(readerService.saveReader(new Reader("Zhaku", 24, "Zhaku@gmail.com")));
                    System.out.println(readerService.saveReader(new Reader("Baku", 23, "Baku@gmail.com")));
                    System.out.println(readerService.saveReader(new Reader("Beka", 20, "Bek@gmail.com")));
             }case 15->{
                    System.out.println(readerService.updateReader(3L, new Reader("Manas", 28, "manas@gmail.com")));
             }case 16->{
                    System.out.println("Write id for delete: ");
                    System.out.println(readerService.deleteReaderById(new Scanner(System.in).nextLong()));
                }

            }
        }
    }
}
