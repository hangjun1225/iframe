package com.hr.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hr.service.ExampleService;

public class ExampleServiceImpl implements ExampleService {
	
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public Integer add() {
		return 1;
	}
}
