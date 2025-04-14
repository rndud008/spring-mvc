package hello.hellobasic.dicount;

import hello.hellobasic.member.Grade;
import hello.hellobasic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }

        return 0;
    }
}
