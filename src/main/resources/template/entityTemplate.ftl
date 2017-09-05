package  ${tableEntity.packageName};

import java.io.Serializable;

/**
 * 
 * @ClassName: ${tableEntity.className} 
 * @Description: ${tableEntity.className}实体类,此代码是代码生成器自动化生成。
 * @company 
 * @author auto code builder
 * @Email auto code builder
 * @date ${nowDate} 
 *
 */
public class ${tableEntity.className} implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = ${serialVersionUID?c}L;
	<#list tableEntity.columns as col>	
	private ${col.classAttrType} ${col.classAttr};//${col.columnAnnotations!}!
	</#list>
	
	<#list tableEntity.columns as col>
	/**${col.columnAnnotations!}!*/
	public ${col.classAttrType} get${col.endStr}() {
		return ${col.classAttr};
	}
	/**${col.columnAnnotations!}!*/
	public void set${col.endStr}(${col.classAttrType} ${col.classAttr}) {
		this.${col.classAttr} = ${col.classAttr};
	}
	</#list>
	
}
