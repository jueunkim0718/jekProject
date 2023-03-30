package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; //천원 고정할인
    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.vip){
            return discountFixAmount;
        }else{
            return 0;
        }

    }
}
