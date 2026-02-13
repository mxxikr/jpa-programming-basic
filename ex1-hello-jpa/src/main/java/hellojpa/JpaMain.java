package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin(); // 트랜잭션 시작

        try {

            Member member1 = new Member();
            member1.setUsername("hello");
            entityManager.persist(member1);

            Member member2 = new Member();
            member2.setUsername("hello2");
            entityManager.persist(member2);

            entityManager.flush();
            entityManager.clear();

            Member findMember = entityManager.getReference(Member.class, member1.getId());
            Member findMember2 = entityManager.getReference(Member.class, member2.getId());

            System.out.println("findMember = " + findMember.getClass());

            Member reference = entityManager.getReference(Member.class, findMember.getId());
            System.out.println("reference.getClass() = " + reference.getClass());

            System.out.println("a == a: " + (findMember == reference));

            System.out.println("m1 == m2: " + (findMember.getClass() == findMember2.getClass()));
            System.out.println("m1 == m2: " + (findMember instanceof Member));

//            Member findMember = entityManager.find(Member.class, member.getId());
            System.out.println("findMember.getClass() = " + findMember.getClass());
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getUsername() = " + findMember.getUsername());

            Hibernate.initialize(findMember); // 강제 초기화

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }

        emf.close();
    }
}