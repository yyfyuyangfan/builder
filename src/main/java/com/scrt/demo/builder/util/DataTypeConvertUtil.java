package com.scrt.demo.builder.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;

import com.scrt.demo.builder.attribute.CommonAttribute;


/**
 * 
  * @ClassName: DataTypeConvertUtil 
  * @Description: 数据类型转换工具类，主要用于把数据库类型转换为java类型
  * @company 
  * @author woaishop.com
  * @Email woaishop.com
  * @date 2015年7月2日 
  *
 */
public class DataTypeConvertUtil {
	/**数据类型对应集合 key为sql类型 val为java类型*/
	public static Map<String, String> dataTypes=new HashMap<String, String>();
	//静态加载
	static{
		PropertiesUtil propertiesUtil = PropertiesUtil.getPropertiesUtil();
		Properties properties = propertiesUtil.getPropertiesByRalPath(CommonAttribute.PROPERTIES_FILE_RALPATH,CommonAttribute.DTATYPE_FILE_NAME);
		//绝对路径加载
		//Properties properties = propertiesUtil.getProperties(CommonAttribute.DATATYPECONVERT_FILE_LOCALPATH);
		Set<Entry<Object, Object>> entrySet = properties.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			dataTypes.put(String.valueOf(entry.getKey()).toUpperCase(),String.valueOf(entry.getValue()));
		}
	}
	/**
	 * 
	 * @Title: convertDataType 
	 * @Description: 根据sql类型获取java类型
	 * @param sqlType 数据库字段类型
	 * @return String 如com.long.String
	 */
	public static String convertDataType(String sqlType){
		if(StringUtil.isEmpty(sqlType)){
			return "Object";
		}
		return dataTypes.get(sqlType.toUpperCase());
	}
	
	@Test
	public void t1(){
		StringBuilder sb=new StringBuilder();
		sb.append("".substring(0, 1).toLowerCase());//类属性手字母小写
		sb.append("".substring(1));//其他字符跟随数据库
		System.out.println(sb.toString());
	}
	
}
