package org.zerock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {
	// Mapper를 주입 받는다. : ReplyMapper, BoardMapper
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Setter(onMethod_ = @Autowired)		// 게시글의 댓글 수를 갱신하기 위하여 필요.
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		log.info("register..." + vo);
		// tbl_board 테이블의 replyCnt를 증가
		boardMapper.updateReplyCnt(vo.getBno(), 1);	// tbl_board
		return mapper.insert(vo);					// tbl_reply
	}

	@Override
	public ReplyVO get(Integer rno) {
		log.info("get..." + rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		log.info("modify..." + vo);
		return mapper.update(vo);
	}

	@Transactional
	@Override
	public int remove(Integer rno) {
		log.info("remove..." + rno);
		ReplyVO vo = mapper.read(rno);					// tbl_reply
		boardMapper.updateReplyCnt(vo.getBno(), -1);	// tbl_board
		return mapper.delete(rno);						// tbl_reply
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Integer bno) {
		log.info("get List of a Board " + bno);
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Integer bno) {
		// page -1일 경우 처리를 해주어야 한다. -> 댓글의 수와 빈 목록을 반환
		if(cri.getPageNum() == -1) {	// 댓글의 수만 필요함
			return new ReplyPageDTO(mapper.getCountByBno(bno),
					new ArrayList<ReplyVO>());
		} else {
			return new ReplyPageDTO(mapper.getCountByBno(bno),
					mapper.getListWithPaging(cri, bno));
		}
	}
}