package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    //싱글톤으로 관리 - 생성자 private으로 막아놓음 - 조회만 public
    private static final MemberRepository instance = new MemberRepository();
    private MemberRepository(){
    }
    public static MemberRepository getInstance(){
        return instance;
    }

    //회원 저장
    public Member save(Member member){
        member.setId(sequence++);
        store.put(member.getId(), member);
        return member;
    }

    //회원 조회
    public Member findById(Long id) {
        return store.get(id);
    }
    public List<Member> findAll(){
        //다른 곳에서 배열을 수정해도 store에 영향이 가지 않도록 ArrayList로 돌려준다.
        return new ArrayList<>(store.values());
    }

    //테스트용
    public void clearStore(){
        store.clear();
    }

}
