package com.scrt.demo.builder.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scrt.demo.builder.entity.TestEntity;
import com.scrt.demo.builder.service.TestService;

/**
 * 
* @ClassName: DataController 
* @Description: TODO
* @company 
* @author woaishop.com
* @Email woaishop.com
* @date 2015年6月30日 
*
 */
@Controller
@RequestMapping("testController/")
public class TestController {
	@Autowired
	private TestService testService;
	/**
	 * 
	 * @Title: add 
	 * @Description: 添加
	 * @param testEntity
	 * @return
	 */
	@RequestMapping("add")
	public @ResponseBody Integer add(TestEntity testEntity) {
		try {
			return testService.add(testEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * 
	 * @Title: add 
	 * @Description: 修改
	 * @param testEntity
	 * @return
	 */
	@RequestMapping("update")
	public @ResponseBody Integer update(TestEntity testEntity) {
		try {
			return testService.update(testEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}/**
	 * 
	 * @Title: add 
	 * @Description: 修改
	 * @param testEntity
	 * @return
	 */
	@RequestMapping("delete")
	public @ResponseBody Integer delete(Integer id) {
		try {
			return testService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}/**
	 * 
	 * @Title: add 
	 * @Description: 修改
	 * @param testEntity
	 * @return
	 */
	@RequestMapping("select")
	public @ResponseBody List<TestEntity> select() {
		try {
			return testService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
