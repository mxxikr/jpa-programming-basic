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
            // 비영속
            Member member = new Member();
            member.setId(102L);
            member.setName("HelloA");

            // 영속
            System.out.println("=== BEFORE ===");
            entityManager.persist(member);
            System.out.println("=== AFTER ===");

            Member findMember = entityManager.find(Member.class, 102L);

            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

            Member findMember2 = entityManager.find(Member.class, 100L);
            Member findMember3 = entityManager.find(Member.class, 100L);

            System.out.println("result = " + (findMember2 == findMember3));

            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            entityManager.persist(member1);
            entityManager.persist(member2);

            Member member3 = entityManager.find(Member.class, 150L);
            member3.setName("ZZZZZZ");
            System.out.println("============================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }

        emf.close();
    }
}