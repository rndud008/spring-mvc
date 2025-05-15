package hello.hellobasic.domain;

import hello.hellobasic.BaseEntity;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Category extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String  name;
    @ManyToOne
    @JoinColumn(name = "PARNET_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
        joinColumns = @JoinColumn(name = "CATEGORY_ID"),
        inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<Item> items = new ArrayList<>();

}
