package hello.hellobasic.domain;

import hello.hellobasic.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
public class Delivery extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String  city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery")
    private Order order;

}
