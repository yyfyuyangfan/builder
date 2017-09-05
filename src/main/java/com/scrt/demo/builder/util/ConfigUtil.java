package com.scrt.demo.builder.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import com.scrt.demo.builder.attribute.CommonAttribute;

public class ConfigUtil {
	/**基本配置的缓存map*/
	public static Map<String, String> configs=new HashMap<String, String>();
	//静态加载
	static{
		PropertiesUtil propertiesUtil = PropertiesUtil.getPropertiesUtil();
		//Properties properties = propertiesUtil.getPropertiesByRalPath(CommonAttribute.CONFIG_FILE_PATH,CommonAttribute.CONFIG_FILE_NAME);
		Properties properties = propertiesUtil.getPropertiesByRalPath(CommonAttribute.PROPERTIES_FILE_RALPATH,CommonAttribute.CONFIG_FILE_NAME);
		load(properties);
	}
	/**
	 * 
	 * @Title: getByKey 
	 * @Description: 根据key获取缓存集合中的值
	 * @param key 配置文件中的key
	 * @return String value
	 */
	public static  String getByKey(String key){
		return configs.get(key);
	}
	/**
	 * 
	 * @Title: load 
	 * @Description: 加载配置文件到内存中,方便使用
	 */
	public static void load(Properties properties){
		Set<Entry<Object, Object>> entrySet = properties.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			configs.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()));
		}
	}
}
