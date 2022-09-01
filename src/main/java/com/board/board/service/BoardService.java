package com.board.board.service;

import com.board.board.domain.Board;
import com.board.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
//Board.java에서 데이터를 받아와서 적용
    public void write(Board board) {
        boardRepository.save(board);
    }
//글을 불러 올 메소드
    public List<Board> boardList() {
        return boardRepository.findAll();
    }

}
