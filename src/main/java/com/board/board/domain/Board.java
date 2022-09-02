package com.board.board.domain;

import javax.persistence.*;

@Entity// JPA 테이블 매핑
public class Board {
    @Id //기본키 매핑
    @SequenceGenerator(
            name = "MEMBER_SEQ_GENERATOR",
            sequenceName = "seq", // 매핑할 데이터베이스 시퀀스 이름
            initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR") //postgersql의 주키를 sequence컬럼을 이용하기 때문에 auto로 설정
    /*@Id //기본키 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private Long id;
    private String title;
    private String content;

    private String filename;

    private String filepath;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
