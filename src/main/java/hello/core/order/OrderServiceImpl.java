package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //필수값이 (final) 가진 필드들을 모아 생성자를 만들어준다. (ctrl+F12 를 보면 확인가능)
public class OrderServiceImpl  implements  OrderService{

    //private final MemberRepository memberRepository= new MemoryMemberRepository();
    //고정할인금액
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //정률할인금액
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    //문제점 DiscountPolicy 할인역할을 하는 클래스가 직접 FixDiscountPolicy 또는 RateDiscountPolicy 을 쓸지 직접 지정 하면 안된다
    //해결책 : 관심사를 분리하자
    //구현객체를 생성하고 연결하는 책임을 가지는 별도의 설정 클래스를 만든다
    //ex) 공연기획자가 직접 배우를 섭외하는 역할을 해야한다. 배우가 상대배우를 캐스팅하는 일까지 해서는 안된다. 배우는 연기를 해야한다.
    //AppConfig등장 구성(config)

    //역할인 OrderServiceImpl 이 (주문역할)
    //구현객체인 RateDiscountPolicy 의존하지않도록 final 상수 제거 (할인역할_구현체)

     private  final MemberRepository memberRepository;
     private   final DiscountPolicy discountPolicy ;

     @Autowired //생성자가 딱 한개있으면 생략가능
    //alt+insert 통해서 주문역할(OrderServiceImpl)의 생성자를 생성하고 구체적역할(memberRepository,discountPolicy) 주입시킨다.
     //ctrl + alt + b 누르면 구현채로 열어볼수 있다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println(" ====OrderServiceImpl==== " );
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    };
    //AppCofig 에서
    /*public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
    }*/
    //이렇게 OrderService 에 리턴값이 MemoryMemberRepository, FixDiscountPolicy 를 넣어준다
    //만약할인정책이 바뀌어서 FixDiscountPolicy 대신 RateDiscountPoiicy를 보낼수도있다.
    //다시말해 OrderServiceImpl 주문역할을 하는 객체는 주문역할을 하면된다. => DIP 준수

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //싱글톤 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
