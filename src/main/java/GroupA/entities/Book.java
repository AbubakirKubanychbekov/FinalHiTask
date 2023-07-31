package GroupA.entities;
import GroupA.enums.Genre;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "books")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Book extends ParentSuperClass{
    private String name;
    private String country;
    @Column(name = "published_Year")
    @Temporal(TemporalType.DATE)
    private LocalDate publishedYear;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    },fetch = FetchType.EAGER)
    private Publisher publisher;
    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    },fetch = FetchType.EAGER)
    private Reader reader;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    public Book(String name, String country, LocalDate publishedYear, BigDecimal price, Genre genre) {
        this.name = name;
        this.country = country;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
    }
}
