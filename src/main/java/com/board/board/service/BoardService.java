package com.board.board.service;

import com.board.board.domain.Board;
import com.board.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository; //jparepository를 이용해서 findall과 같은 메소드 이용
//Board.java에서 데이터를 받아와서 적용
    //글작성
    public void write(Board board, MultipartFile file) throws Exception {

        String porjectPath = System.getProperty("user.dir") +"\\src\\main\\resources\\static\\files";
        UUID uuid = UUID.randomUUID(); //file 식별자 랜덤 부여
        String filename = uuid +"_"+file.getOriginalFilename(); //파일 이름은 식별자에 원래 이름 부여
        File saveFile = new File(porjectPath, filename);
        file.transferTo(saveFile);

        board.setFilename(filename);
        board.setFilepath("/files/"+filename);
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
