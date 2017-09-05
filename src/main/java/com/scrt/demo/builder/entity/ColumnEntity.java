package com.scrt.demo.builder.entity;

import java.io.Serializable;

import com.scrt.demo.builder.util.DataTypeConvertUtil;
import com.scrt.demo.builder.util.StringUtil;

/**
 * 
  * @ClassName: ColumnEntity 
  * @Description: 数据列字段信息实体
  * @company 
  * @author woaishop.com
  * @Email woaishop.com
  * @date 2015年7月2日 
  *
 */
public class ColumnEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7164465835507390429L;
	
	private String columnName;//列名
	private String classAttr;//类属性名
	private String endStr;//get set 后面的名称
	private String columnType;//列类型
	private String classAttrType;//类属性类型
	private Integer datasize;//数据大小
	private Integer isNull;	//是否为空
	private String remarks;//描述
	private Integer isPrimaryKey;//是否是主键
	private Integer isAutoIncrement;//是否自增
	private String columnAnnotations;//列注释
	
	//类常量
	/**有*/
	public static final Integer YES=1;
	/**没有*/
	public static final Integer NO=0;
	
	public ColumnEntity() {
		super();
	}


	public String getColumnName() {
		return columnName;
	}


	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}


	public String getClassAttr() {
		if(StringUtil.isEmpty(classAttr)){
			return StringUtil.firstCharToLowerCase(columnName);
		}
		return classAttr;
	}


	public void setClassAttr(String classAttr) {
		this.classAttr = classAttr;
	}


	public String getColumnType() {
		return columnType;
	}


	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}


	public String getClassAttrType() {
		if(StringUtil.isEmpty(classAttrType)){
			return DataTypeConvertUtil.convertDataType(this.columnType);
		}
		return classAttrType;
	}


	public void setClassAttrType(String classAttrType) {
		this.classAttrType = classAttrType;
	}


	public Integer getDatasize() {
		return datasize;
	}


	public void setDatasize(Integer datasize) {
		this.datasize = datasize;
	}


	public Integer getIsNull() {
		return isNull;
	}


	public void setIsNull(Integer isNull) {
		this.isNull = isNull;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public Integer getIsPrimaryKey() {
		return isPrimaryKey;
	}


	public void setIsPrimaryKey(Integer isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}


	public Integer getIsAutoIncrement() {
		return isAutoIncrement;
	}


	public void setIsAutoIncrement(Integer isAutoIncrement) {
		this.isAutoIncrement = isAutoIncrement;
	}


	public String getColumnAnnotations() {
		return columnAnnotations;
	}


	public void setColumnAnnotations(String columnAnnotations) {
		this.columnAnnotations = columnAnnotations;
	}


	public String getEndStr() {
		if(StringUtil.isEmpty(endStr)){
			return StringUtil.firstCharToUpperCase(columnName);
		}
		return endStr;
	}


	public void setEndStr(String endStr) {
		this.endStr = endStr;
	}

	
}
