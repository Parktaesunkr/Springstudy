package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO { // lombok 사용

	private Long bno; // 게시글 번호
	private String title; // 게시글 제목
	private String content; // 게시글 내용
	private String writer; // 작성자
	private Date regdate; // 작성일
	private Date updateDate; // 수정일
}
