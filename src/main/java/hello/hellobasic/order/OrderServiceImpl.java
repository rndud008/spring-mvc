package hello.hellobasic.order;

import hello.hellobasic.dicount.DiscountPolicy;
import hello.hellobasic.dicount.FixDiscountPolicy;
import hello.hellobasic.member.Member;
import hello.hellobasic.member.MemberRepository;
import hello.hellobasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
