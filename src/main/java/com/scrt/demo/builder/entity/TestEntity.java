package com.scrt.demo.builder.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: ${tableEntity.className} 
 * @Description: ${tableEntity.className}实体类
 * @company 
 * @author auto code builder
 * @Email auto code builder
 * @date ${nowData} 
 *
 */
public class TestEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2899825657732585812L;
	
	private Integer id;//id
	private Date date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String name;//名字
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
