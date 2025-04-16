package hello.hellobasic.dicount;

import hello.hellobasic.member.Grade;
import hello.hellobasic.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000; // 1000 원 할인
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }

        return 0;
    }
}
