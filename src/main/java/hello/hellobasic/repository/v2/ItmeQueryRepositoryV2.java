package hello.hellobasic.repository.v2;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.hellobasic.domain.Item;
import hello.hellobasic.domain.QItem;
import hello.hellobasic.repository.ItemSearchCond;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static hello.hellobasic.domain.QItem.item;

@Repository
public class ItmeQueryRepositoryV2 {
    private final JPAQueryFactory query;

    public ItmeQueryRepositoryV2(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    public List<Item> findAll(ItemSearchCond cond) {
        return query.select(item)
                .from(item)
                .where(
                        likeItemNAme(cond.getItemName())
                        , maxPrice(cond.getMaxPrice()))
                .fetch();
    }

    private BooleanExpression likeItemNAme(String itemName) {

        if (StringUtils.hasText(itemName)) {
            return item.itemName.like("%" + itemName + "%");
        }

        return null;
    }

    private Predicate maxPrice(Integer maxPrice) {
        if (maxPrice != null) {
            return item.price.loe(maxPrice);
        }

        return null;
    }
}
