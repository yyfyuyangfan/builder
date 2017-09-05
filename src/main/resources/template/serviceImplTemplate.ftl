package ${basePackage}.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${basePackage}.entity.${tableEntity.className};
import ${basePackage}.dao.${tableEntity.className}Dao;
import ${basePackage}.service.${tableEntity.className}Service;
import ${basePackage}.util.StringUtil;

@Service("${tableEntity.className}ServiceImpl")
public class ${tableEntity.className}ServiceImpl implements ${tableEntity.className}Service {
	@Autowired
	private ${tableEntity.className}Dao ${functionParName}Dao;
	
	@Override
	public List<${tableEntity.className}> getAll() {
		return ${functionParName}Dao.getAll();
	}

	@Override
	public Integer add(${tableEntity.className} ${functionParName}) {
		if(StringUtil.isEmpty(${functionParName})){
			return -1;
		}
		return ${functionParName}Dao.add(${functionParName});
	}

	@Override
	public Integer update(${tableEntity.className} ${functionParName}) {
		if(StringUtil.isEmpty(${functionParName})){
			return -1;
		}
		return ${functionParName}Dao.update(${functionParName});
	}

	@Override
	public Integer delete(
		<#list tableEntity.columns as col>	
			<#if col.isPrimaryKey == 1 >
				${col.classAttrType} ${col.classAttr}
				<#assign functionParamName=col.classAttr>
			</#if>
		</#list>) {
		if(StringUtil.isEmpty(${functionParamName})){
			return -1;
		}
		return ${functionParName}Dao.delete(${functionParamName});
	}

}
