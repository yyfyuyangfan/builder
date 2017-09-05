<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${basePackage}.dao.${tableEntity.className}Dao">

	<select id="getAll" resultType="${basePackage}.entity.${tableEntity.className}">
		select * from ${tableEntity.tableName}
	</select>
	<insert id="add" parameterType="${basePackage}.entity.${tableEntity.className}">
		${INSERTSQL}
	</insert>
	<update id="update" parameterType="${basePackage}.entity.${tableEntity.className}">
		update 
			${tableEntity.tableName}
		set 
			${UPDATEPARAMSQL}
		where
		<#list tableEntity.columns as col>	
			<#if col.isPrimaryKey == 1 >
				${col.columnName}=${"#"}{${col.classAttr}}
			</#if>
		</#list>
	</update>
	 <#list tableEntity.columns as col>	
			<#if col.isPrimaryKey == 1 >
				<#assign classAllName=col.classAttrType>
			</#if>
		</#list>
	<delete id="delete" parameterType="${classAllName}">
		delete from
		 ${tableEntity.tableName}
	    where
		 <#list tableEntity.columns as col>	
			<#if col.isPrimaryKey == 1 >
				${col.columnName}=${"#"}{${col.classAttr}}
				<#assign classAllName=col.classAttrType>
			</#if>
		</#list>
	</delete>
</mapper>