package com.scrt.demo.builder.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.scrt.demo.builder.service.BuilderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-*.xml")
public class TestClass {
	@Autowired
	private BuilderService builderService;
	@Test
	public void test() throws Exception{
		//builderService.builderBySql();
	}
	@Test
	public void t2() throws Exception{
		new ZipUtil().doZip("E:/autoCode", "E:/builder.zip");
	}
	
	@Test
	public void t3() throws Exception{
		//List<TableEntity> parsePDM_VO = PdmReadUtil.parsePDM_VO("F:/tempCode/Mi-Base.pdm");
		//System.out.println(parsePDM_VO.size());
	}
	@Test
	public void t4() throws Exception{
		String[] split = "t1:dao,service,mapper@".split("@");
		System.out.println(split[0]);
	}
	@Test
	public void t5() throws Exception{
		//删除也存在的目录
		new FileUtil().deleteFolder("E:/autoCode/");
	}
}
