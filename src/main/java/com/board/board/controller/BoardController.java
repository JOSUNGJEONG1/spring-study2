package com.board.board.controller;

import com.board.board.domain.Board;
import com.board.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("board/write")
    public String boardWriteForm() {
        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board) {
        boardService.write(board);
        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList()); //반환 된 boardList를 "list"이름으로 받아넘긴다
        return "boardlist"; //return할 html 작성
    }

    @GetMapping("/board/view")//localhost:8080/board/view?id=?
    public String boardView(Model model, Long id){
        model.addAttribute("board", boardService.boardview(id));
        return "boardview";
    }
    @GetMapping("/board/delete")
    public String boardDelete(Long id) {
        boardService.boardDelete(id);

        return "redirect:/board/list";
    }
}
