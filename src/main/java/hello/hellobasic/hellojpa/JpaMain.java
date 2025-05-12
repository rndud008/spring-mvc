package hello.hellobasic.hellojpa;

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

//            생성
//            비영속
//            Member member = new Member();
//            member.setName("HelloB");
//            member.setId(2l);
//
//            영속
//            em.persist(member);

//            수정 + 조회
//            Member findMember = em.find(Member.class, 1l);
//            findMember.setName("HelloJPA");

//            조회
//            Member findMember1 = em.find(Member.class, 1l);
//            Member findMember2 = em.find(Member.class, 1l);
//            위의 것은 퀘리가 한번만 조회됨.
//            System.out.println("result findMember1 == findMember2 = " + findMember1 == findMember2); // true

//            조회
//            List<Member> result = em.createQuery("select m from Member m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(7)
//                    .getResultList();
//            for (Member member : result){
//                System.out.println("member.getName() = " + member.getName());
//            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
