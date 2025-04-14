package hello.hellobasic.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long id);
}
