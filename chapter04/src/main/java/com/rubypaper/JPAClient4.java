package com.rubypaper;

import com.rubypaper.domain.Board;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAClient4 {
    public static void main(String[] args) {
        // EntityManager 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04");
        EntityManager em = emf.createEntityManager();

        // Transaction 생성
        EntityTransaction tx = em.getTransaction();

        try {
            // Transaction 시작
            tx.begin();

            // 수정할 게시글 조회
            Board board = em.find(Board.class, 1L);

            // 게시글 삭제
            board.setSeq(1L);
            em.remove(board);

            // Transaction Commit
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            // Transaction rollback
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}