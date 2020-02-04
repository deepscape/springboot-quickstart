package com.rubypaper.persistence;

import com.rubypaper.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    List<Board> findByTitle(String searchKeyword);
    List<Board> findByContentContaining(String searchKeyword);
    List<Board> findByTitleContainingOrContentContaining(String title, String content);
    List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
    //List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
    Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);

    @Query("select b from Board b where b.title like %?1% order by b.seq desc")
    List<Board> queryAnnotationTest1(String searchKeyword);

    @Query("select b from Board b where b.title like %:searchKeyword% order by b.seq desc")
    List<Board> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);

    @Query("select b.seq, b.title, b.writer, b.createDate from Board b where b.title like %:searchKeyword% order by b.seq desc")
    List<Object[]> queryAnnotationTest3(@Param("searchKeyword") String searchKeyword);

    @Query(value="select seq, title, writer, create_date from board where title like '%' || ?1 || '%' order by seq desc", nativeQuery = true)
    List<Object[]> queryAnnotationTest4(String searchKeyword);

    @Query("select b from Board b order by b.seq desc")
    List<Board> queryAnnotationTest5(Pageable paging);
}