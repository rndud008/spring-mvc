package hello.hellobasic.repository.v2;

import hello.hellobasic.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepositoryV2 extends JpaRepository<Item, Long> {

}
