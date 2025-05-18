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

//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            // 연관관계의 주인
//            Member member = new Member();
//            member.setUsername("member1");
//            // 연관관계 편의 메서드 사용
//            // 편의메서드는 한곳에서만 관리.
//            member.changeTeam(team);
//            em.persist(member);
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

//            Member member = new Member();
//            member.setUsername("member1");
//
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//            team.getMembers().add(member);
//
//            em.persist(team);


//            Movie movie = new Movie();
//            movie.setDirector("aaa");
//            movie.setActor("bbbb");
//            movie.setName("바라괌과함께사라지다");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//            em.flush();
//            em.clear();
//
//            Movie findMovie = em.find(Movie.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);

//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
////            CASCADE 설정으로 child 의 persist 를 통해 작성안할수도 있음.
////            CASCADE 는 단일 종속적일때만 사용하는게 좋음 다른곳에서 같이 사용하면 원하지않는 동작발동가능성있음.
////            em.persist(child1);
////            em.persist(child2);
//
//            em.flush();
//            em.clear();
//
////            고아객체
////            orphanRemoval = true 설정
////            참조가 제거된 엔티티는 다른곳에서 참조하지 않는 고아 객체로 보고 삭제하는 기능
////            참조하는곳이 하니일때 사용해야 하고 특정엔티티가 개인 소유일때 사용
//            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(0);


            Member member = new Member();
            member.setUsername("hello");
            member.setHomeAddress(new Address("city", "street", "10000"));
            member.setWorkPeriod(new Period());

            em.persist(member);


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
