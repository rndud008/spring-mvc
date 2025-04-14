package hello.hellobasic.order;

import hello.hellobasic.dicount.DiscountPolicy;
import hello.hellobasic.dicount.FixDiscountPolicy;
import hello.hellobasic.dicount.RateDiscountPolicy;
import hello.hellobasic.member.Member;
import hello.hellobasic.member.MemberRepository;
import hello.hellobasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
