package com.rubypaper;

import com.rubypaper.domain.Board;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAClient2 {
    public static void main(String[] args) {
        // EntityManager 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04");
        EntityManager em = emf.createEntityManager();

        try {
            // 글 상세 조회
            Board searchBoard = em.find(Board.class, 1L);
            System.out.println("---> " + searchBoard.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
