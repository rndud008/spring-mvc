package hello.hellobasic.repository.mybatis;

import hello.hellobasic.domain.Item;
import hello.hellobasic.repository.ItemSearchCond;
import hello.hellobasic.repository.ItemUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {

    void save(Item item);

    void update(@Param("id") Long id, @Param("updateParam")ItemUpdateDto itemUpdateDto);

    Optional<Item> findById(Long id);
    List<Item> findAll(ItemSearchCond itemSearchCond);

}
