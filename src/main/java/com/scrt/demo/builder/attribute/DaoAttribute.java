package com.scrt.demo.builder.attribute;
/**
 * @ClassName: DaoAttribute 
 * @Description: 鎸佷箙灞傜敤鍒扮殑鍩烘湰甯搁噺锛屽父涓庢暟鎹簱瀛楁瀵瑰簲.
 * @company 
 * @author yixiang.deng
 * @Email 553067271@qq.com
 * @date 2015骞�鏈�0鏃�
 *
 */
public class DaoAttribute {
	/**mysql椹卞姩绫�/
	 * 
	 */
	public static final String MYSQL_DRIVER="com.mysql.jdbc.Driver";
	/**mysql鑾峰彇鏁版嵁搴撴墍鏈夎〃sql*/
	public static final String MYSQL_GETALLTABLESNAMESQL="select table_name from information_schema.tables where table_schema=?";
	/**mysql鑾峰彇鏌愪釜琛ㄧ殑鎵�湁瀛楁淇℃伅*/
	public static final String MYSQL_GETCOLUMNINFOSQL="select COLUMN_NAME,DATA_TYPE,COLUMN_TYPE,COLUMN_KEY,EXTRA,COLUMN_COMMENT,IS_NULLABLE from information_schema.columns where table_name = ?";
	
	/**mssql椹卞姩绫�/
	 * 
	 */
	public static final String MSSQL_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
}
