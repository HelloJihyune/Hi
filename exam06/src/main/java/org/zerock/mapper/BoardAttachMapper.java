package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardAttachVO;

public interface BoardAttachMapper {
	
	public void insert(BoardAttachVO vo);
	public int delete(String uuid);
	public List<BoardAttachVO> findByBno(Integer bno);
	public void deleteAll(Integer bno); //해당 게시글의 첨부파일 정보를 삭제
	public List<BoardAttachVO>getOldFiles(); //어제 날짜로 첨부 파일의 정보를 가져온다
}
