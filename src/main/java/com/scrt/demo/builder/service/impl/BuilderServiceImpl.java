package com.scrt.demo.builder.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.dom4j.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrt.demo.builder.attribute.CommonAttribute;
import com.scrt.demo.builder.entity.ColumnEntity;
import com.scrt.demo.builder.entity.Level;
import com.scrt.demo.builder.entity.TableEntity;
import com.scrt.demo.builder.service.BuilderService;
import com.scrt.demo.builder.util.ConfigUtil;
import com.scrt.demo.builder.util.DateUtil;
import com.scrt.demo.builder.util.DbUtils;
import com.scrt.demo.builder.util.FileUtil;
import com.scrt.demo.builder.util.FreemarkUtil;
import com.scrt.demo.builder.util.LevelUtil;
import com.scrt.demo.builder.util.PdmReadUtil;
import com.scrt.demo.builder.util.StringUtil;
import com.scrt.demo.builder.util.ZipUtil;

import freemarker.template.TemplateException;
@Service("builderServiceImpl")
public class BuilderServiceImpl implements BuilderService {
	@Autowired
	private FreemarkUtil freemarkUtil;
	@Override
	public List<TableEntity> getAllTableBySql(){
		String url=ConfigUtil.getByKey(CommonAttribute.JDBC_URL);
		String name=ConfigUtil.getByKey(CommonAttribute.JDBC_USERNAME);
		String pwd=ConfigUtil.getByKey(CommonAttribute.jdbc_PASSWORD);
		DbUtils db=new DbUtils(); 
		Connection con = db.getCon(url,name,pwd);
		return db.getAllTables(con, ConfigUtil.getByKey(CommonAttribute.DATABASENAME));
	}
	@Override
	public List<Level>  getlevels(){
		return LevelUtil.levels;
	}

	@Override
	public Integer builderBySql(String tables) throws IOException, TemplateException {
		//获取配置
		//PropertiesUtil propertiesUtil = PropertiesUtil.getPropertiesUtil();
		//Properties properties = propertiesUtil.getPropertiesByRalPath(CommonAttribute.PROPERTIES_FILE_RALPATH, CommonAttribute.CONFIG_FILE_NAME);
		String url=ConfigUtil.getByKey(CommonAttribute.JDBC_URL);
		String name=ConfigUtil.getByKey(CommonAttribute.JDBC_USERNAME);
		String pwd=ConfigUtil.getByKey(CommonAttribute.jdbc_PASSWORD);
		DbUtils db=new DbUtils(); 
		Connection con = db.getCon(url,name,pwd);
		List<TableEntity> allTables = db.getAllTables(con, ConfigUtil.getByKey(CommonAttribute.DATABASENAME));
		List<TableEntity> findCheckTable = findCheckTable(tables, allTables);
		if(StringUtil.isEmpty(findCheckTable)){//数据库没有table
			return -1;
		}
		for (TableEntity tableEntity : findCheckTable) {
			//获取列属性
			con = db.getCon(url,name,pwd);
			List<ColumnEntity> columnInfos = db.getColumnInfos(con, tableEntity.getTableName());
			tableEntity.setColumns(columnInfos);
			create(tableEntity);//构建
		}
		new ZipUtil().doZip(ConfigUtil.getByKey(CommonAttribute.TEMP_PATH), ConfigUtil.getByKey(CommonAttribute.ZIP_PATH));
		return 1;
	}

	@Override
	public void create(TableEntity tableEntity){
		//freemark 模板参数map
		Map<String, Object> tempMap=new HashMap<String, Object>();
		//添加属性
		tempMap.put(CommonAttribute.FTL_PARAM_TABLE, tableEntity);
		tempMap.put(CommonAttribute.FTL_PARAM_UUID, UUID.randomUUID().getLeastSignificantBits());
		tempMap.put(CommonAttribute.FTL_PARAM_NOWDATE, DateUtil.getNowDate(DateUtil.DATA_FORMAT));
		tempMap.put(CommonAttribute.FTL_PARAM_PARNAME, StringUtil.firstCharToLowerCase(tableEntity.getClassName()));
		tempMap.put(CommonAttribute.BASEPACKAGE, ConfigUtil.getByKey(CommonAttribute.BASEPACKAGE));
		tempMap.put(CommonAttribute.FTL_PARAM_UPDATE_COL_SQLSTR, getUpdateParamSql(tableEntity.getColumns()));
		tempMap.put(CommonAttribute.FTL_INSERT_SQLSTR, getInsertSql(tableEntity));

		//tableEntity.setLeves("entity,dao,service,service.impl,controller,mapper");
		//获取前台勾选，并处理
		String leveStr = tableEntity.getLeves();
		if(StringUtil.isEmpty(leveStr)){
			return ;
		}
		String [] leves=leveStr.split(",");
		//删除也存在的目录
		new FileUtil().deleteFolder(ConfigUtil.getByKey(CommonAttribute.TEMP_PATH));

		for (Level leve : LevelUtil.levels) {
			//判断是否需要生成该层次代码
			if(isIncludes(leve.getPackagez(), leves)){
				//设置包名 共有包+独立包
				tableEntity.setPackageName(ConfigUtil.getByKey(CommonAttribute.BASEPACKAGE)+"."+leve.getPackagez());
				//设置类名 表名首字母大写+结束字符  :test+Dao
				//tableEntity.setClassName(StringUtil.firstCharToUpperCase(tableEntity.getTableName())+leve.getEndStr());

				//设置文件名 test+Dao+.+java=testDao.java
				StringBuilder sb=new StringBuilder();
				sb.append(tableEntity.getClassName());
				if(!tableEntity.getClassName().endsWith(leve.getEndStr())){
					sb.append(leve.getEndStr());
				}
				sb.append(".");
				sb.append(leve.getFileSuffix());
				//文件路径
				StringBuilder filePath=new StringBuilder();
				filePath.append(ConfigUtil.getByKey(CommonAttribute.TEMP_PATH));
				if(leve.getPackagez().startsWith("/")){//mapper 暂时
					filePath.append("resources/");
					filePath.append(leve.getPackagez().substring(leve.getPackagez().indexOf("/")+1,leve.getPackagez().length()));
				}else{
					filePath.append("java/");
					filePath.append(tableEntity.getPackageName());
				}
				freemarkUtil.saveFilebyStr(leve.getFtlName(), tempMap, filePath.toString(),sb.toString());
			}
		}

	}

	//在某个数组是否包含某个字符
	private boolean isIncludes(String str,String [] strs){
		for (int i = 0; i < strs.length; i++) {
			if(str.equals(strs[i])){
				return true;
			}
		}
		return false;
	}
	//查找table并赋值Leves,标明该表需要生成那些层次
	private List<TableEntity> findCheckTable(String tables,List<TableEntity> tableEntities){
		if(StringUtil.isEmpty(tables)){//没有待生成的的table
			return null;
		}
		if(StringUtil.isEmpty(tableEntities)){//数据库没有table
			return null;
		}
		String [] tableStr=tables.split("@");
		for (String tempTableStr : tableStr) {
			String[] split = tempTableStr.split(":");
			for (TableEntity tableEntity : tableEntities) {
				if(tableEntity.getTableName().equals(split[0])){
					tableEntity.setLeves(split[1]);
				}
			}
		}
		return tableEntities;
	}
	@Override
	public List<TableEntity> getAllTableByPdm(InputStream inputStream) {
		Document doc = PdmReadUtil.getDoc(inputStream);
		return PdmReadUtil.parsePDM_VO(doc);
	}
	@Override
	public Integer builderByPdm(String tables, List<TableEntity> tableEntities) {
		List<TableEntity> findCheckTable = findCheckTable(tables, tableEntities);
		if(StringUtil.isEmpty(findCheckTable)){//数据库没有table
			return -1;
		}
		for (TableEntity tableEntity : findCheckTable) {
			create(tableEntity);//构建
		}
		new ZipUtil().doZip(ConfigUtil.getByKey(CommonAttribute.TEMP_PATH), ConfigUtil.getByKey(CommonAttribute.ZIP_PATH));
		return 1;
	}
	//得到update set参数
	private String getUpdateParamSql(List<ColumnEntity> columnEntity){
		if(StringUtil.isEmpty(columnEntity)){
			return "";
		}
		StringBuilder sb=new StringBuilder();
		for (ColumnEntity col : columnEntity) {
			if(!ColumnEntity.YES.equals(col.getIsPrimaryKey())){
				sb.append(col.getColumnName());
				sb.append("=#{");
				sb.append(col.getClassAttr());
				sb.append("},");
			}
		}
		if(sb.length()>0){
			return sb.substring(0, sb.length()-1);
		}
		return sb.toString();
	}

	//得到insert sql
	private String getInsertSql(TableEntity tableEntity){
		List<ColumnEntity> columns = tableEntity.getColumns();
		if(StringUtil.isEmpty(columns)){
			return "";
		}
		StringBuilder insertSql=new StringBuilder();
		insertSql.append(" insert into ");
		insertSql.append(tableEntity.getTableName());
		insertSql.append(" ( ");
		
		StringBuilder sbPar=new StringBuilder();
		StringBuilder sbVAl=new StringBuilder();
		for (ColumnEntity col : columns) {
			//不是主键
			if(!ColumnEntity.YES.equals(col.getIsPrimaryKey())){
				sbVAl.append("#{");
				sbVAl.append(col.getClassAttr());
				sbVAl.append("},");

				sbPar.append(col.getColumnName());
				sbPar.append(",");
			}else{
				//id是不是自增,需拼接id
				if(!ColumnEntity.YES.equals(col.getIsAutoIncrement())){
					sbVAl.append("#{");
					sbVAl.append(col.getClassAttr());
					sbVAl.append("},");

					sbPar.append(col.getColumnName());
					sbPar.append(",");
				}
			}
		}
		if(sbPar.length()>0){
			sbPar.substring(0, sbPar.length()-1);
		}
		if(sbVAl.length()>0){
			sbVAl.substring(0, sbPar.length()-1);
		}
		insertSql.append(sbPar);
		insertSql.append(" ) values ( ");
		insertSql.append(sbVAl);
		insertSql.append(" )");
		return insertSql.toString();
	}
}
