package org.zerock.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadForm {
	private String desc;				// 입력받는 정보
	private MultipartFile[] uploadFile;	// 첨부 파일
}
