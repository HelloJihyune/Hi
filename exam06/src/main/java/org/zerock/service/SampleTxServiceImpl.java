package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.Sample1Mapper;
import org.zerock.mapper.Sample2Mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 하나의 트랜잭션으로 2개의 SQL 문을 실행하면서 두 개의 SQL문의 성공하면 commit을 하고
// 둘 중의 하나가 에러가 나면 다시 원래로 돌리고 싶다. -> 트랜잭션 처리가 필요하고

@Service
@Log4j
public class SampleTxServiceImpl implements SampleTxService {
	// mapper 2개가 필요
	@Setter(onMethod_ = @Autowired)
	private Sample1Mapper mapper1;
	
	@Setter(onMethod_ = @Autowired)
	private Sample2Mapper mapper2;

	@Transactional	// 트랜잭션 처리를 하도록 요청을 하는 어노테이션 -> AOP가 적용되었다는 것을 알 수 있음
	@Override
	public void addData(String value) {
		// 두 개의 테이블에 데이터를 저장
		log.info("mapper1...");
		mapper1.insertCol1(value);	// tbl_sampl1에 저장
		log.info("mapper2...");
		mapper2.insertCol2(value);	// tbl_sampl2에 저장
		log.info("end...");
	}
}