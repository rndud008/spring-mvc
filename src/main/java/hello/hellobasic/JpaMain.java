package hello.hellobasic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            Member findMember= em.find(Member.class, member.getId());
//
//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);


//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            Member findMember= em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//            for (Member m : members) {
//                System.out.println("m = " + m);
//            }
//            Team findTeam =findMember.getTeam();
//            System.out.println("findTeam = " + findTeam);



//            // 연관관계의 주인
//            Member member = new Member();
//            member.setUsername("member1");
//            em.persist(member);
//
//            // 연관 관계의 주인이 아닌곳에 주입을 하게되면 저장되지 않음.
//            Team team = new Team();
//            team.setName("TeamA");
//            team.getMembers().add(member);
//            em.persist(team);
//
//            Member findMember= em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//            for (Member m : members) {
//                System.out.println("m = " + m);
//            }
//            Team findTeam =findMember.getTeam();
//            System.out.println("findTeam = " + findTeam);


//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            // 연관관계의 주인
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            // 순수 객체 상태를 고려해서 항상 양쪽에 값을 설정
//            team.getMembers().add(member);
//
//            em.flush();
//            em.clear();
//
//            Member findMember= em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//            for (Member m : members) {
//                System.out.println("m = " + m);
//            }
//            Team findTeam =findMember.getTeam();
//            System.out.println("findTeam = " + findTeam);

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            // 연관관계의 주인
            Member member = new Member();
            member.setUsername("member1");
            // 연관관계 편의 메서드 사용
            // 편의메서드는 한곳에서만 관리.
            member.changeTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember= em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();
            for (Member m : members) {
                System.out.println("m = " + m);
            }
            Team findTeam =findMember.getTeam();
            System.out.println("findTeam = " + findTeam);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
