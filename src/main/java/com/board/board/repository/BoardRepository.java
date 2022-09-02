package com.board.board.repository;

import com.board.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);

}//어떤 개체를 넣을지, 기본키의 데이터타입
