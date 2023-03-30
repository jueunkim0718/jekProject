package hello.core.member;

public interface MemberRepository {

    //구현체는 따로 생성 MemoryMemberRepository
    //MemoryMemberRepository 는 implements MemberRepository 한다

    /*
    extends
        부모에서 선언 / 정의를 모두하며 자식은 메소드 / 변수를 그대로 사용할 수 있음
    implements (interface 구현)
        부모 객체는 선언만 하며 정의(내용)은 자식에서 오버라이딩 (재정의) 해서 사용해야함
    abstract
        extends와 interface 혼합. extends하되 몇 개는 추상 메소드로 구현되어 있음
*/
    //회원저장
    void save(Member member);

    //아이디로 회원찾기
    Member findById(Long memberId);
}
