package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	// 게시글에 대한 댓글을 조작을 편하게 하기 위해 배열
	private Integer[] bnoArr = { 1572836, 1572835, 1572834, 1572833, 1572832 };
	
	@Setter(onMethod_ = @Autowired)	// Mapper를 주입받음
	private ReplyMapper mapper;
	
//	@Test
	public void testMapper() {
		log.info(mapper);			// mapper가 주입이 되어 사용 가능한지 테스트
	}
	
//	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer" + i);
			mapper.insert(vo);		// 댓글을 추가
		});
	}
	
//	@Test
	public void testRead() {
		Integer targetRno = 5;
		ReplyVO vo = mapper.read(targetRno);
		log.info(vo);
	}
	
//	@Test
	public void testDelete() {
		Integer targetRno = 5;		// 존재하는 rno를 사용
		int count = mapper.delete(targetRno);
		log.info("Delete Count: " + count);
	}
	
//	@Test
	public void testUpdate() {
		Integer targetRno = 10;		// 존재하는 rno를 사용
		ReplyVO vo = mapper.read(targetRno);
		vo.setReply("Update Reply");
		int count = mapper.update(vo);
		log.info("Update Count: " + count);
	}
	
//	@Test
	public void testList() {
		Criteria cri = new Criteria();	// default로 1 page, 10개
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		replies.forEach(reply -> log.info(reply));
	}
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2, 10);	// default로 1 page, 10개
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		replies.forEach(reply -> log.info(reply));
	}
}
