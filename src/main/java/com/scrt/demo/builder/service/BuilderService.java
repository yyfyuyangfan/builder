package com.scrt.demo.builder.service;

import java.io.InputStream;
import java.util.List;

import com.scrt.demo.builder.entity.Level;
import com.scrt.demo.builder.entity.TableEntity;


/**
 * 
 * @ClassName: BuilderService 
 * @Description: 代码生成器逻辑层
 * @company 
 * @author woaishop.com
 * @Email woaishop.com
 * @date 2015年7月2日 
 *
 */
public interface BuilderService {
	/**
	 * 
	 * @Title: getlevels 
	 * @Description: 获取所有的代码层次
	 * @return
	 */
	public List<Level>  getlevels();
	/**
	 * 
	 * @Title: getAllTableBySql 
	 * @Description: 获取数据库全部的表
	 * @return
	 */
	public List<TableEntity> getAllTableBySql();
	/**
	 * 
	 * @Title: getAllTableByPdm 
	 * @Description: 获取数据库全部的表
	 * @param inputStream pdm文件的输入流
	 * @return
	 */
	public List<TableEntity> getAllTableByPdm(InputStream inputStream);
	/**
	 * 
	 * @param tables 
	 * @Title: builderBySql 
	 * @Description: 通过数据库创建模板
	 * @return
	 * @throws Exception
	 */
	public Integer builderBySql(String tables) throws Exception;
	/**
	 * 
	 * @Title: create 
	 * @Description: 创建本地文件
	 * @param tableEntity 表格实体
	 */
	public void create(TableEntity tableEntityp);
	/**
	 * 
	 * @Title: builderByPdm 
	 * @Description: 通过pdm生成
	 * @param tables 选中的表
	 * @param tableEntities pdm文件中所有表
	 * @return
	 */
	public Integer builderByPdm(String tables, List<TableEntity> tableEntities);
}
