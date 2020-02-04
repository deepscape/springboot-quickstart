package com.rubypaper;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest2 {
    @Autowired
    BoardRepository boardRepo;

    @Test
    public void testFindByContentContaining() {
        List<Board> boardList = boardRepo.findByContentContaining("17");

        System.out.println("검색 결과");
        for(Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    @Test
    public void testFindByTitleContainingOrContentContaining() {
        List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("174", "184");

        System.out.println("검색 결과");
        /*
            for(Board board : boardList) {
            System.out.println("---> " + board.toString());
            }
        */

        boardList.stream().forEach(x -> System.out.println("--->" + x.toString()));
        boardList.stream().map((x) -> {return x.getCnt()+10000;}).forEach(x -> System.out.println("--->" + x.toString()));
    }

    @Test
    public void testFindByTitleContainingOrderBySeqDesc() {
        List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");

        System.out.println("검색 결과");
        boardList.stream().forEach(x -> System.out.println("---> " + x.toString()));
    }

    @Test
    public void testFindByTitleContaining() {
        // Pageable paging = PageRequest.of(6, 5);
        Pageable paging = PageRequest.of(6, 5, Sort.Direction.DESC, "seq");
        // List<Board> boardList = boardRepo.findByTitleContaining("제목", paging);
        Page<Board> boardList = boardRepo.findByTitleContaining("제목", paging);

        System.out.println("PAGE SIZE : " + boardList.getSize());
        System.out.println("TOTAL PAGES : " + boardList.getTotalPages());
        System.out.println("TOTAL COUNT : " + boardList.getTotalElements());

        System.out.println("검색 결과");
        boardList.stream().forEach(x -> System.out.println("--->" + x.toString()));
    }
}