package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    //ALT + SHIFT + ENTER 자동완성
    //MemberRepository 구현체인 MemoryMemberRepository생성

    //저장소에 사용할 맵
    //비지니스 요구사항(회원) :  회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정) => 메모리에서만 사용하기 떄문에 off 되어버리면 데이터는 날라간다
    //실무에서는 동시성 이슈 때문에 HashMap 대신에 ConcurrentHashMap 사용하도록한다.
    private static Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
