package com.scrt.demo.builder.util;

import java.util.ArrayList;
import java.util.List;

import com.scrt.demo.builder.attribute.CommonAttribute;
import com.scrt.demo.builder.attribute.ExceptionAttribute;
import com.scrt.demo.builder.entity.Level;

/**
 * 
 * @ClassName: LevelUtil 
 * @Description: TODO
 * @company 
 * @author woaishop.com
 * @Email woaishop.com
 * @date 2015年7月3日 
 *
 */
public class LevelUtil {
	//缓存代码层次
	public static List<Level> levels=new ArrayList<Level>();
	//分隔符
	private static final String SEPARATOR=",";
	static{
		//获取配置文件中配置的属性
		String packagez = ConfigUtil.getByKey(CommonAttribute.PACKAGE);
		String endStr = ConfigUtil.getByKey(CommonAttribute.ENDSTR);
		String ftlName = ConfigUtil.getByKey(CommonAttribute.FTLNAME);
		String fileSuffix = ConfigUtil.getByKey(CommonAttribute.FILESUFFIX);
		//没有配置或配置有误抛异常
		if(StringUtil.isEmpty(packagez,endStr,ftlName,fileSuffix)){
			throw new RuntimeException(ExceptionAttribute.LEVEL_R1_EXCEPTION);
		}
		//使用，分割配置属性
		String [] packages=packagez.split(SEPARATOR);
		String [] endStrs=endStr.split(SEPARATOR);
		String [] ftlNames=ftlName.split(SEPARATOR);
		String [] fileSuffixs=fileSuffix.split(SEPARATOR);
		if(StringUtil.isEmpty(packages)){
			throw new RuntimeException(ExceptionAttribute.LEVEL_R2_EXCEPTION);
		}
		//判断配置的属性一一对应
		boolean flag=(packages.length+endStrs.length+ftlNames.length+fileSuffixs.length)/4==packages.length;
		if(!flag){
			StringBuilder sb=new StringBuilder();
			sb.append("结构层次不统一,请检查:");
			sb.append(CommonAttribute.PACKAGE);
			sb.append("-");
			sb.append(CommonAttribute.ENDSTR);
			sb.append("-");
			sb.append(CommonAttribute.FTLNAME);
			sb.append("-");
			sb.append(CommonAttribute.FILESUFFIX);
			sb.append(" 是否一一对应！");
			throw new RuntimeException(sb.toString());
		}
		//填充到集合
		for (int i = 0; i < packages.length; i++) {
			levels.add(new Level(packages[i], endStrs[i], ftlNames[i], fileSuffixs[i]));
		}
	}
	
}
