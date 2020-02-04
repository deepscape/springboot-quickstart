package com.rubypaper;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest3 {
    @Autowired
    private BoardRepository boardRepo;

    @Test
    public void testQueryAnnotionTest1() {
        List<Board> boardList = boardRepo.queryAnnotationTest1("테스트 제목 10");

        System.out.println("검색 결과");
        boardList.stream().forEach(x -> System.out.println(x.toString()));
    }

    @Test
    public void testQueryAnnotionTest2() {
        List<Board> boardList = boardRepo.queryAnnotationTest2("테스트 제목 10");

        System.out.println("검색 결과");
        boardList.stream().forEach(x -> System.out.println(x.toString()));
    }

    @Test
    public void testQueryAnnotionTest3() {
        List<Object[]> boardList = boardRepo.queryAnnotationTest3("테스트 제목 10");

        System.out.println("검색 결과");
        boardList.stream().forEach(x -> System.out.println(Arrays.toString(x)));
    }

    @Test
    public void testQueryAnnotionTest4() {
        List<Object[]> boardList = boardRepo.queryAnnotationTest4("테스트 제목 10");

        System.out.println("검색 결과");
        boardList.stream().forEach(x -> System.out.println(Arrays.toString(x)));
    }

    @Test
    public void testQueryAnnotationTest5() {
        Pageable paging = PageRequest.of(0,3, Sort.Direction.DESC, "seq");
        List<Board> boardList = boardRepo.queryAnnotationTest5(paging);

        System.out.println("검색 결과");
        boardList.stream().forEach(x -> System.out.println(x.toString()));
    }

}