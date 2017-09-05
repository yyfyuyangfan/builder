package com.scrt.demo.builder.service;

import java.util.List;

import com.scrt.demo.builder.entity.TestEntity;

/**
 * 
 * @ClassName: TestDao 
 * @Description: TODO
 * @company 
 * @author woaishop.com
 * @Email woaishop.com
 * @date 2015年7月3日 
 *
 */
public interface TestService {
	/**
	 * 
	 * @Title: getAll 
	 * @Description: 获取全部的数据
	 * @return List<TestEntity>
	 */
	public List<TestEntity> getAll();
	/**
	 * 
	 * @Title: add 
	 * @Description: 新增
	 * @param testEntity
	 * @return 返回受影响行数
	 */
	public Integer add(TestEntity testEntity);
	/**
	 * 
	 * @Title: add 
	 * @Description: 修改
	 * @param testEntity
	 * @return 返回受影响行数
	 */
	public Integer update(TestEntity testEntity);
	/**
	 * 
	 * @Title: delete 
	 * @Description: 通过id删除
	 * @param id
	 * @return 返回受影响行数
	 */
	public Integer delete(Integer id);
}
