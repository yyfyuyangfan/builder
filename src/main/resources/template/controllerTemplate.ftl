package ${tableEntity.packageName};

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ${basePackage}.entity.${tableEntity.className};
import ${basePackage}.service.${tableEntity.className}Service;

/**
 * 
* @ClassName: DataController 
* @Description: TODO
* @company 
* @author woaishop.com
* @Email woaishop.com
* @date 2015年6月30日 
*
 */
@Controller
@RequestMapping("${functionParName}Controller/")
public class ${tableEntity.className}Controller {
	@Autowired
	private ${tableEntity.className}Service ${functionParName}Service;
	/**
	 * 
	 * @Title: add 
	 * @Description: 添加
	 * @param testEntity
	 * @return
	 */
	@RequestMapping("add")
	public @ResponseBody Integer add(${tableEntity.className} ${functionParName}) {
		try {
			return ${functionParName}Service.add(${functionParName});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * 
	 * @Title: add 
	 * @Description: 修改
	 * @param testEntity
	 * @return
	 */
	@RequestMapping("update")
	public @ResponseBody Integer update(${tableEntity.className} ${functionParName}) {
		try {
			return ${functionParName}Service.update(${functionParName});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}/**
	 * 
	 * @Title: delete 
	 * @Description: 删除
	 * @param testEntity
	 * @return
	 */
	@RequestMapping("delete")
	public @ResponseBody Integer delete(<#list tableEntity.columns as col>	
			<#if col.isPrimaryKey == 1 >
				${col.classAttrType} ${col.classAttr}
				<#assign functionParamName=col.classAttr>
			</#if>
		</#list>) {
		try {
			return ${functionParName}Service.delete(${functionParamName});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}/**
	 * 
	 * @Title: getAll 
	 * @Description: 查询
	 * @param testEntity
	 * @return
	 */
	@RequestMapping("getAll")
	public @ResponseBody List<${tableEntity.className}> getAll() {
		try {
			return ${functionParName}Service.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
