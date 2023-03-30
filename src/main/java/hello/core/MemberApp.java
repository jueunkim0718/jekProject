package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    //psvm 단축키
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        
        
        //ctrl + alt + v
        Member member = new Member(1L, "memberA", Grade.vip);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        //단축키 syso >> soutv
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
