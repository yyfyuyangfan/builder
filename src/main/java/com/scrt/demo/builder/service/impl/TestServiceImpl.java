package com.scrt.demo.builder.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scrt.demo.builder.dao.TestDao;
import com.scrt.demo.builder.entity.TestEntity;
import com.scrt.demo.builder.service.TestService;
import com.scrt.demo.builder.util.StringUtil;

@Service("testServiceImpl")
public class TestServiceImpl implements TestService {
	//@Autowired
	private TestDao testDao;
	
	@Override
	public List<TestEntity> getAll() {
		return testDao.getAll();
	}

	@Override
	public Integer add(TestEntity testEntity) {
		if(StringUtil.isEmpty(testEntity)){
			return -1;
		}
		return testDao.add(testEntity);
	}

	@Override
	public Integer update(TestEntity testEntity) {
		if(StringUtil.isEmpty(testEntity)){
			return -1;
		}
		return testDao.update(testEntity);
	}

	@Override
	public Integer delete(Integer id) {
		if(id==null){
			return -1;
		}
		return testDao.delete(id);
	}

}
