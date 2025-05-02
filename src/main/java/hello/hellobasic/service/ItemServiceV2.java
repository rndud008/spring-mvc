package hello.hellobasic.service;


import hello.hellobasic.domain.Item;
import hello.hellobasic.repository.ItemRepository;
import hello.hellobasic.repository.ItemSearchCond;
import hello.hellobasic.repository.ItemUpdateDto;
import hello.hellobasic.repository.v2.ItemRepositoryV2;
import hello.hellobasic.repository.v2.ItmeQueryRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemServiceV2 implements ItemService {

    private final ItemRepositoryV2 itemRepositoryV2;
    private final ItmeQueryRepositoryV2 itmeQueryRepositoryV2;

    @Override
    public Item save(Item item) {
        return itemRepositoryV2.save(item);
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Item findItem = itemRepositoryV2.findById(itemId).orElseThrow();
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());

    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepositoryV2.findById(id);
    }

    @Override
    public List<Item> findItems(ItemSearchCond cond) {
        return itmeQueryRepositoryV2.findAll(cond);
    }
}
