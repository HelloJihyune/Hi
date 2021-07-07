package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {
	// 표준 빈(Bean) : 필드와 생성자
	// 필드
	private List<SampleDTO> list;
	
	// default 생성자
	private SampleDTOList() {
		list = new ArrayList<SampleDTO>();
	}
}
