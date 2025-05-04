package hello.hellobasic.model;

import java.util.HashMap;
import java.util.*;
import java.util.Map;

public class MemberRepository {

    private static Map<String, Member> store = new HashMap<>();

    public void save(Member member)   {
        store.put(member.getUsername(), member);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

}
