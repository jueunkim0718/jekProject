package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(
        basePackages = "hello.core", //지정된 패키지 하위의 component만 스캔하도록 지정할 수 있다.(모든걸 다 스캔하면 오래걸릴경우)
        //basePackageClasses = AutoAppConfig.class, //클래스 지정도 가능하다.
        //지정하지 않으면 지금 패키지의 위치 hello.core 부터 다 스캔하게 된다.
        //권장하는 방법은 설정 정보 클래스의 위치를 프로젝트 최상단에 두면 > default 로 지정되어 그 위치부터 스캔하게 된다.
        //@SpringBootApplication 안에 @ComponentScan 있는데 @SpringBootApplication 실행위치인 CoreApplication 패키지 위치가 hello.core 이기때문에
        //자동으로 스캔하게 된다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION , classes = Configuration.class)
) //@Configuration 에 기본적으로 @Component 있기 떄문에 exclude 시켜준다. 지금은 참고 테스트 중이기때문에..
public class AutoAppConfig {

    //수동 빈 등록이 우선구너을 가진다(수동빈이 자동빈을 오버라이딩해준다)
//    @Bean("memoryMemberRepository")
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }

}

