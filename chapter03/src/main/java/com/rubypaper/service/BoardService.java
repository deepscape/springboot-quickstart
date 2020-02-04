package com.rubypaper.service;

import com.rubypaper.domain.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {
    String hello(String name);
    BoardVO getBoard();
    List<BoardVO> getBoardList();
}
