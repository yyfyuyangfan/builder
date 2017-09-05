package com.scrt.demo.builder.attribute;
/**
* @ClassName: CommonAttribute 
* @Description: 系统基本常量, 表现层请求常量等
* @company 
* @author woaishop.com
* @Email woaishop.com
* @date 2015年6月30日 
*
 */
public class CommonAttribute {
	/**基本配置文件相对路径*/
	public static final String  PROPERTIES_FILE_RALPATH="properties/";
	/**系统配置文件名*/
	public static final String  CONFIG_FILE_NAME="config.properties";
	/**类型映射配置*/
	public static final String  DTATYPE_FILE_NAME="dataTypeConvert.properties";
	
	/**config.properties 配置文件的本地路径*/
	public static final String CONFIG_FILE_LOCALPATH="C:/Users/colin/Desktop/代码生成器demo/原码maven工程/builder/src/main/resources/properties/config.properties";
	/**dataTypeConvert.properties 配置文件的本地路径*/
	public static final String DATATYPECONVERT_FILE_LOCALPATH="C:/Users/colin/Desktop/代码生成器demo/原码maven工程/builder/src/main/resources/properties/dataTypeConvert.properties";
	
	/**JDBC jdbc_driver (key)*/
	public static final String  JDBC_DRIVER="jdbc_driver";
	/**JDBC jdbc_url (key)*/
	public static final String  JDBC_URL="jdbc_url";
	/**JDBC jdbc_username (key)*/
	public static final String  JDBC_USERNAME="jdbc_username";
	/**JDBC jdbc_password (key)*/
	public static final String  jdbc_PASSWORD="jdbc_password";
	/**JDBC databaseName (key)*/
	public static final String  DATABASENAME="databaseName";
	
	/**共有包路径(key)*/
	public static final String  BASEPACKAGE="basePackage";
	/**生成代码临时存放位置(key)*/
	public static final String TEMP_PATH="temp_path";
	/**压缩文件临时存放位置 (key)*/
	public static final String ZIP_PATH="zip_path";
	
	/**保存文件后缀.java*/
	//public static final String  FILE_SUFFIX_JAVA=".java";
	/**保存文件后缀.xml*/
	//public static final String  FILE_SUFFIX_XML=".xml";
	/**保存文件后缀.txt*/
	//public static final String  FILE_SUFFIX_DEFAULT=".txt";
	
	/**实体类包路径 (key)*/
	public static final String  PACKAGE="package";
	/**实体类名的后缀 (key)*/
	public static final String  ENDSTR="endStr";
	/**实体类模板文件名 (key)*/
	public static final String  FTLNAME="ftlName";
	/**文件后缀(key)*/
	public static final String  FILESUFFIX="fileSuffix";
	
	
	/**freemarker 参数*/
	public static final String  FTL_PARAM_TABLE="tableEntity";
	/**freemarker 参数*/
	public static final String  FTL_PARAM_UUID="serialVersionUID";
	/**freemarker 参数*/
	public static final String  FTL_PARAM_NOWDATE="nowDate";
	/**freemarker 参数*/
	public static final String  FTL_PARAM_PARNAME="functionParName";
	/**freemarker 参数*/
	public static final String  FTL_PARAM_UPDATE_COL_SQLSTR="UPDATEPARAMSQL";
	/**freemarker 参数*/
	public static final String  FTL_INSERT_SQLSTR="INSERTSQL";
	
}
