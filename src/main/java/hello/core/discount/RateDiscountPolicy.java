package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;


    // ctrl  + shift + T => 자동 테스트 완성
    // Junit5를 쓰고 나머지는 건들지말것.
    @Override
    public int discount(Member member, int price) {

        if(member.getGrade()== Grade.vip){
            return price * discountPercent /100;
        }else{
            return 0;
        }

    }
}
