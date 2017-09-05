package com.scrt.demo.builder.entity;
/**
 * 
 * @ClassName: Level 
 * @Description: 生成代码层次配置实体类
 * @company 
 * @author woaishop.com
 * @Email woaishop.com
 * @date 2015年7月3日 
 *
 */
public class Level {
	
	private String packagez;
	private String endStr;
	private String ftlName;
	private String fileSuffix;
	
	public Level() {
		super();
	}
	public Level(String packagez, String endStr, String ftlName,
			String fileSuffix) {
		super();
		this.packagez = packagez;
		this.endStr = endStr;
		this.ftlName = ftlName;
		this.fileSuffix = fileSuffix;
	}
	public String getPackagez() {
		return packagez;
	}
	public void setPackagez(String packagez) {
		this.packagez = packagez;
	}
	public String getEndStr() {
		return endStr;
	}
	public void setEndStr(String endStr) {
		this.endStr = endStr;
	}
	public String getFtlName() {
		return ftlName;
	}
	public void setFtlName(String ftlName) {
		this.ftlName = ftlName;
	}
	public String getFileSuffix() {
		return fileSuffix;
	}
	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}
	
}
