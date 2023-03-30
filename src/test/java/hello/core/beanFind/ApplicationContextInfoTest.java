package hello.core.beanFind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("모든 빌 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter >> 배열 iterator
        //자동완성
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBeanDefinitionNames();
            System.out.println("beanDefinitionName = " + beanDefinitionName + " && object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void  finApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter >> 배열 iterator
        //자동완성
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition  beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            //ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            //ROLE_INFRASTRUCTURE : 스프링 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("beanDefinitionName = " + beanDefinitionName + " && object = " + bean);
            }
        }
    }
}
