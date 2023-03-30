package hello.core.singletone;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingletone(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService stat1 = ac.getBean(StatefulService.class);
        StatefulService stat2 = ac.getBean(StatefulService.class);

        // ThreadA : A사용자가 10000원 주문
        int userAprice =  stat1.order("UserA", 10000);
        // ThreadA : B사용자가 20000원 주문
        int userBprice =   stat1.order("UserB", 20000);

        //ThreadA :  사용자 A 주문 금액 조회
/*
        int price =stat1.getPrice();
        System.out.println("price = " + price);
*/
        System.out.println("userAprice = " + userAprice);
        System.out.println("userBprice = " + userBprice);

        Assertions.assertThat(userAprice).isEqualTo(10000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}

