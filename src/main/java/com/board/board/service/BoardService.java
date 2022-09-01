package com.board.board.service;

import com.board.board.domain.Board;
import com.board.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository; //jparepository를 이용해서 findall과 같은 메소드 이용
//Board.java에서 데이터를 받아와서 적용
    //글작성
    public void write(Board board) {
        boardRepository.save(board);
    }
    //글을 불러 올 메소드
    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    //특정 게시글
    public Board boardview(Long id) {
        return boardRepository.findById(Long.valueOf(id)).get();
    }

    public void boardDelete(Long id){
        boardRepository.deleteById(id);
    }


}
