package hellojpa.jpql;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin(); // 트랜잭션 시작

        try {
            Team team = new Team();
            team.setName("teamA");
            entityManager.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            member.setTeam(team);

            entityManager.flush();
            entityManager.clear();

            String query = "select nullif(m.username, '관리자') from Member m ";


            List<String> resultList = entityManager.createQuery(query, String.class).getResultList();

            for (String s : resultList) {
                System.out.println("s = " + s);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }

        emf.close();
    }
}