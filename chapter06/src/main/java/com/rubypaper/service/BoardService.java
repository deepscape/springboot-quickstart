package com.rubypaper.service;

import com.rubypaper.domain.Board;

import java.util.List;

// Intellij Refactor 기능 활용 -> interface 추출
public interface BoardService {
    List<Board> getBoardList(Board board);

    void insertBoard(Board board);

    Board getBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(Board board);
}
