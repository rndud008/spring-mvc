package hello.hellobasic.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.Objects;

@Embeddable
@Getter
public class Address {
    @Column(length = 10)
    private String city;
    @Column(length = 20)
    private String street;
    @Column(length = 5)
    private String zipcode;


    public String fullAddress(){
        return getCity() + " " + getStreet() + " "  + getZipcode();
    }

    // 메서드 호출시 필드 직접접근이 아니라 getter 로 가져와야 프록시로 접근해서 안전함 ?,,?
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
