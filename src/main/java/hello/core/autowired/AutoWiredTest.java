package hello.core.autowired;

import hello.core.member.Member;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    public void autowiredTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }
    static class TestBean{

        @Autowired(required = false) //기본값 true, 값이 없으면 메서드 자체가 호출이 안되게 false 로 지정
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) { //@Nullable 옵션을 통해서 널이면 null 로 표현
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) { //Optional 옵션을 통해 없으면 Optional.empty
            System.out.println("noBean3 = " + noBean3);
        }

    }
}
