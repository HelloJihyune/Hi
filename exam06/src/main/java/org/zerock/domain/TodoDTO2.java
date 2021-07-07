package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO2 {
	private String title;
	// 브라우저에서 올라오는 yyyy/MM/dd 문자열을 Date 객체로 저장 
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date dueDate;
}
