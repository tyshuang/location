package com.yuma.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuma.mapper.TestMapper;
import com.yuma.service.TestService;


@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper mapper;
	
	@Override
	public String query() {
		// TODO Auto-generated method stub
		//注入mapper
		//使用mapper的方法
		System.out.println(1);
		return mapper.queryNow();
	}

}
