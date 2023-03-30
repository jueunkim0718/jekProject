package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // @Autowired MemberRepository MemberRepository;


    //AppConfig는 생성한 객체 인스턴스의 참조(래퍼런스)를 생성자를 통해서 주입(연결)해준다
    //연결 , 구성 => config, 관심사 분리
    //DIP 완성 : MemberServiceImpl 은 MemberRepository인 추상에만 의존하면 된다.
    //이제 구체클래스를 몰라도 된다
    //관심사의 분리 : 객체를 생성하고 연결하는 역할과 실행하는 역할이 명확히 분리된다.

    //제어의 역전 IOC 란
    //프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 제어의 역전이라고 한다.
    //프레임워크 VS 라이브러리
    //프레임워크가 내가 작성한 코드를 제어하고, 대신 실행하면 그것은 프레임워크가 맞다.(JUnit)
    //반면에 내가 작성한 코드가 직접 제어의 흐름을 담당하면 그것은 프레임워크가 아니라 라이브러리다.

    //@Bean memberService=>new MemoryMemberRepository()
    //@Bean orderService=>new MemoryMemberRepository()

    @Bean
    public MemberService memberService(){
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    //리펙토링 alt + ctrl + m > new  MemoryMemberRepository 커서를 잡고
    //리펙토링 이유 new MemoryMemberRepository 중복될수있다 메서드를 만들고 그것을 호출 하시는식으로 역할을 분명히한다.
    @Bean
    public  MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
        //return null;
    }
    //리펙토링 alt + ctrl + m > new RateDiscountPolicy 커서를 잡고
    //리펙토링 이유 New RateDiscountPolicy 중복될수있다 메서드를 만들고 그것을 호출 하시는식으로 역할을 분명히한다.
    @Bean
    public  DiscountPolicy discountPolicy() {
        /*return new RateDiscountPolicy();*/
        return new FixDiscountPolicy();
    }



}
