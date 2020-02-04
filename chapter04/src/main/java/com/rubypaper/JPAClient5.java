package com.rubypaper;

import com.rubypaper.domain.Board;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JPAClient5 {
    public static void main(String[] args) {
        // EntityManager 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04");
        EntityManager em = emf.createEntityManager();

        try {
            String jpql = "select b from Board b order by b.seq desc";
            List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();

            for(Board brd : boardList) {
                System.out.println("---> " + brd.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }


    }
}
