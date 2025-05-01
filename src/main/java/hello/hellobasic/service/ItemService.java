package hello.hellobasic.service;

import hello.hellobasic.domain.Item;
import hello.hellobasic.repository.ItemSearchCond;
import hello.hellobasic.repository.ItemUpdateDto;


import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item save(Item item);

    void update(Long itemId, ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    List<Item> findItems(ItemSearchCond itemSearch);
}
