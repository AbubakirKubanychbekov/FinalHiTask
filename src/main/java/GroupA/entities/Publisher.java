package GroupA.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "publishers")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Publisher extends ParentSuperClass{

    private String name;
    private String address;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH,
  //          CascadeType.REMOVE
    },fetch = FetchType.EAGER)
    private List<Author> authors;
    @OneToMany(mappedBy = "publisher",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH,
 //           CascadeType.REMOVE
    },fetch = FetchType.EAGER)
    private List<Book> books;

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
