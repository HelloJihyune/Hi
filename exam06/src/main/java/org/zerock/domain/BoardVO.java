package org.zerock.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	private Integer bno;		// MySQL : int
	private String title;
	private String content;
	private String writer;
	private Date regDate;		// MySQL : datetime (기간의 범위가 더 넓다.)
	private Date updateDate;	// timestamp 
	
	private int replyCnt;		// 댓글의 수
	private List<BoardAttachVO> attachList; //첨부파일 정보
}