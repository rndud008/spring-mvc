package hello.hellobasic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Address address;

    public AddressEntity(){

    }
    public AddressEntity(Address address){
        this.address = address;
    }
}
