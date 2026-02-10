package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin(); // 트랜잭션 시작

        try {
            // 회원 등록
            Member member = new Member();
            member.setId(4L);
            member.setName("HelloA");

            entityManager.persist(member);

            // 회원 수정
//            Member findMember = entityManager.find(Member.class, 1L);
            List<Member> result = entityManager.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();
            
            for (Member m : result) {
                System.out.println("member.getName() = " + member.getName());
            }
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
//            findMember.setName("HelloJPA");
//
            // 회원 삭제
//            entityManager.remove(findMember);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }

        emf.close();
    }
}