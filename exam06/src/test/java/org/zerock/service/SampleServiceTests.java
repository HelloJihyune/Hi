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
public class SampleServiceTests {
	@Setter(onMethod_ = @Autowired)
	private SampleService service;
	
//	@Test
	public void testClass() {
		log.info(service);						// SampleServiceImpl.java 구현객체
		log.info(service.getClass().getName());	// AOP 적용되면서 Proxy 객체를 적용됨
	}
	
	@Test
	public void testAdd() throws Exception {
		log.info(service.doAdd("123", "456"));	// 실행될 때 Proxy 클래스가 실행된다.
	}
	
//	@Test
	public void testAddError() throws Exception {
		log.info(service.doAdd("123", "ABC"));	// NumberFormatException이 발생하도록 ABC 입력
	}
}