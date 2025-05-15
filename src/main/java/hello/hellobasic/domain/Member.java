package hello.hellobasic.domain;

import hello.hellobasic.BaseEntity;
import hello.hellobasic.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

//@Entity
@Getter
@Setter
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    private String city;
    private String strret;
    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();



}
