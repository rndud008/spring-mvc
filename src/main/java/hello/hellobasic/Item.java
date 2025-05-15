package hello.hellobasic;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@DiscriminatorColumn
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;
}
