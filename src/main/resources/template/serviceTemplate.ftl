package ${tableEntity.packageName};

import java.util.List;
import ${basePackage}.entity.${tableEntity.className};

/**
 * 
 * @ClassName: ${tableEntity.className}Service 
 * @Description: 代码生成器自动生成
 * @company 
 * @author woaishop.com
 * @Email woaishop.com
 * @date 2015年7月3日 
 *
 */
public interface ${tableEntity.className}Service {
	/**
	 * 
	 * @Title: getAll 
	 * @Description: 获取全部的数据
	 * @return List<${tableEntity.className}>
	 */
	public List<${tableEntity.className}> getAll();
	/**
	 * 
	 * @Title: add 
	 * @Description: 新增
	 * @param ${functionParName}
	 * @return 返回受影响行数
	 */
	public Integer add(${tableEntity.className} ${functionParName});
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改
	 * @param ${functionParName}
	 * @return 返回受影响行数
	 */
	public Integer update(${tableEntity.className} ${functionParName});
	/**
	 * 
	 * @Title: delete 
	 * @Description: 通过id删除
	 * @param id
	 * @return 返回受影响行数
	 */
	public Integer delete(
		<#list tableEntity.columns as col>	
			<#if col.isPrimaryKey == 1 >
				${col.classAttrType} ${col.classAttr}
			</#if>
		</#list>);
}
