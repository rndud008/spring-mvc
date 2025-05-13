package hello.hellobasic;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID",insertable = false,updatable = false)
    // 읽기 전용으로 사용
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;


//    public void changeTeam(Team team){
//        // 연관관계 편의 메서드
//        this.team = team;
//        team.getMembers().add(this);
//    }
}
