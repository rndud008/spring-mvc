package hello.hellobasic;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
public class Parent {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    //            CASCADE 설정으로 child 의 persist 를 통해 작성안할수도 있음.
//            CASCADE 는 단일 종속적일때만 사용하는게 좋음 다른곳에서 같이 사용하면 원하지않는 동작발동가능성있음.
    //            고아객체
//            orphanRemoval = true 설정
//            참조가 제거된 엔티티는 다른곳에서 참조하지 않는 고아 객체로 보고 삭제하는 기능
//            참조하는곳이 하니일때 사용해야 하고 특정엔티티가 개인 소유일때 사용
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> childList = new ArrayList<>();

    public void addChild(Child child){
        childList.add(child);
        child.setParent(this);
    }

}
