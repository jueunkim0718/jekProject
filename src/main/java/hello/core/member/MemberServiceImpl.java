package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //MemberRepository인터페이스의 다형성에 의해서 구현체인 MemoryMemberRepository 호출
    // ctrl + shift + enter 오토완성
    private final MemberRepository memberRepository ;

    //생성자 주입
    //멤버서비스 역할을 하는 객체에 생성자를 만들어서 MemberRepository 주입시킨다
    //AppConfig(역할구분) 를 통해서 MemberService 는 MemberServiceImpl의 MemberRepository를 생성해서 리턴한다
    //MemberServiceImpl 에서는 MemberRepository 에대해서 의존하지않고 생성자를 통해서를 주입받는다.
    @Autowired //의존관계 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //test 싱글톤유지 확인
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
