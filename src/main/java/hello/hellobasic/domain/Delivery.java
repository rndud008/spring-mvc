package hello.hellobasic.domain;

import hello.hellobasic.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Delivery extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Address address;

    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY)
    private Order order;

}
