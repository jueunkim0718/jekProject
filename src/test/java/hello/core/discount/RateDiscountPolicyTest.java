package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberA", Grade.vip);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        //assertThat > alt + enter > static 으로 올라간다.
        assertThat(discount).isEqualTo(1000);
    }
    //실패 케이스를 항상 테스트 해야한다.
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야한다.")
    void vip_x(){
        //given
        Member member = new Member(1L, "memberA", Grade.basic);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

}