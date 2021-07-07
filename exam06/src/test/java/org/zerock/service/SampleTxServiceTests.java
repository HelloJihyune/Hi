package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTxServiceTests {
	// SampleTxService 객체를 주입 받는다.
	@Setter(onMethod_ = @Autowired)
	private SampleTxService service;
	
	@Test
	public void testLong() {	// tbl_sampl1 테이블에는 저장이 성공되고,
								// tbl_sampl2에는 저장이 안되도록 긴 문자를 추가
		String str = "Starry\r\n" + 
				"Starry night\r\n" +
				"Paint your palette blue and grey\r\n" +
				"Look at on a summer's day";
		log.info(str.getBytes().length);
		service.addData(str);
	}
}
