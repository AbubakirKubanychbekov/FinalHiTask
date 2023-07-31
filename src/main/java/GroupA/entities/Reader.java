package GroupA.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "readers")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Reader extends ParentSuperClass{

  private String name;
  private int age;
  private String email;
  @OneToOne(mappedBy = "reader",
  cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE,
          CascadeType.DETACH,
          CascadeType.REFRESH,
          CascadeType.REMOVE
  },fetch = FetchType.EAGER)
  private Book book;

  public Reader(int age, String email) {
    this.age = age;
    this.email = email;
  }

  public Reader(String name, int age, String email) {
    this.name = name;
    this.age = age;
    this.email = email;
  }
}
