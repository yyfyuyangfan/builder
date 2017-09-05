package com.scrt.demo.builder.entity;

import java.io.Serializable;
import java.util.List;

import com.scrt.demo.builder.util.LevelUtil;
import com.scrt.demo.builder.util.StringUtil;

/**
 * 
 * @ClassName: TableEntity 
 * @Description: 表实体
 * @company 
 * @author woaishop.com
 * @Email woaishop.com
 * @date 2015年7月2日 
 *
 */
public class TableEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4517268718780400993L;
	
	private String tableName;//表名
	private String className;//类名
	private String packageName;//包名
	private String fileName;//保存的文件名
	//private String type;//类型dao,controll,service,serviceImpl,xml
	private String leves;
	private List<ColumnEntity> columns;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getClassName() {
		if(StringUtil.isEmpty(className)){
			//实体结束字符
			String entityEndStr = LevelUtil.levels.get(0).getEndStr();
			this.className=StringUtil.firstCharToUpperCase(tableName)+entityEndStr;
		}
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getLeves() {
		return leves;
	}
	public void setLeves(String leves) {
		this.leves = leves;
	}
	public List<ColumnEntity> getColumns() {
		return columns;
	}
	public void setColumns(List<ColumnEntity> columns) {
		this.columns = columns;
	}
	
	/**静态常量*/
/*	public static final String  TYPE_ENTITY="entity";
	public static final String  TYPE_DAO="dao";
	public static final String  TYPE_DAOXML="mapper";
	public static final String  TYPE_SERVICE="service";
	public static final String  TYPE_SERVICEIMPL="serviceImpl";
	public static final String  TYPE_CONTROLL="controller";*/
	
	
	
	/*public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}*/
	/**
	 * 
	 * @Title: getEndStr 
	 * @Description: 获取类的结束字符
	 * @param type
	 * @return
	 *//*
	public String getEndStr(String type){
		if(StringUtil.isEmpty(type)){
			return "";
		}
		switch (type) {
		case TYPE_ENTITY:
			return ConfigUtil.getByKey(CommonAttribute.ENTITY_ENDSTR);
		case TYPE_DAO:
			return ConfigUtil.getByKey(CommonAttribute.ENTITY_ENDSTR);
		case TYPE_DAOXML:
			return ConfigUtil.getByKey(CommonAttribute.ENTITY_ENDSTR);
		case TYPE_SERVICE:
			return ConfigUtil.getByKey(CommonAttribute.ENTITY_ENDSTR);
		case TYPE_SERVICEIMPL:
			return ConfigUtil.getByKey(CommonAttribute.ENTITY_ENDSTR);
		case TYPE_CONTROLL:
			return ConfigUtil.getByKey(CommonAttribute.ENTITY_ENDSTR);
		}
		return "";
	}*/
}
