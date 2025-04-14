package hello.hellobasic.dicount;

import hello.hellobasic.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);

}
