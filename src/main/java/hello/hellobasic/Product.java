package hello.hellobasic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
//
//    @ManyToMany(mappedBy = "products")
//    private List<Member> members = new ArrayList<>();
    @ManyToMany(mappedBy = "products")
    private List<Member> members = new ArrayList<>();

}