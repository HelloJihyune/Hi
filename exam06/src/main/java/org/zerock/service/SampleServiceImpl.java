package org.zerock.service;

import org.springframework.stereotype.Service;

// Target(핵심 기능을 수행하는 클래스)
@Service
public class SampleServiceImpl implements SampleService {

	@Override
	public Integer doAdd(String str1, String str2) throws Exception {
		return Integer.parseInt(str1) + Integer.parseInt(str2);
	}

	// 핵심 기능을 추가를 하면 공통 기능을 적용할 수 있다.
	// 핵심 기능을 수정하지 않고 공통기능을 적용해서 프로그램을 효과적으로 할 수 있다.
}
