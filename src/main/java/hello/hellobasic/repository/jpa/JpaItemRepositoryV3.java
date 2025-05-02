package hello.hellobasic.repository.jpa;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.hellobasic.domain.Item;
import hello.hellobasic.domain.QItem;
import hello.hellobasic.repository.ItemRepository;
import hello.hellobasic.repository.ItemSearchCond;
import hello.hellobasic.repository.ItemUpdateDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

import static hello.hellobasic.domain.QItem.*;

@Slf4j
@Repository
@Transactional
public class JpaItemRepositoryV3 implements ItemRepository {
    private final EntityManager em;
    private final JPAQueryFactory query;

    public JpaItemRepositoryV3(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public Item save(Item item) {
        em.persist(item);
        return item;
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Item findItem = em.find(Item.class, itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    @Override
    public Optional<Item> findById(Long id) {
        Item item = em.find(Item.class, id);
        return Optional.ofNullable(item);
    }


    public List<Item> findAllOld(ItemSearchCond cond) {

        Integer maxPrice = cond.getMaxPrice();
        String itemName = cond.getItemName();

        BooleanBuilder builder = new BooleanBuilder();
        if (StringUtils.hasText(itemName)){
            builder.and(item.itemName.like("%" + itemName + "%"));
        }
        if (maxPrice != null){
            builder.and(item.price.loe(maxPrice));
        }

        List<Item> result = query.select(item)
                .from(item)
                .where(builder)
                .fetch();
        return result;
    }

    @Override
    public List<Item> findAll(ItemSearchCond cond) {

        Integer maxPrice = cond.getMaxPrice();
        String itemName = cond.getItemName();

        return query.select(item)
                .from(item)
                .where(likeItemNAme(itemName), maxPrice(maxPrice))
                .fetch();
    }

    private BooleanExpression likeItemNAme(String itemName){

        if (StringUtils.hasText(itemName)){
            return item.itemName.like("%"+ itemName +"%");
        }

        return null;
    }

    private Predicate maxPrice(Integer maxPrice){
        if (maxPrice != null){
            return item.price.loe(maxPrice);
        }

        return null;
    }
}
