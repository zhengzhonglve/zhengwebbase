package zheng.base;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.context.ContextLoader;

import com.sun.org.apache.bcel.internal.generic.Type;

import zheng.base.PageBean;
import zheng.data.ConnectionManager;
import zheng.data.Database;
import zheng.data.Parameter;
import zheng.data.ParameterDirection;

/**
 * 基类
 *
 */
public class BaseService{
	
	public static ConnectionManager connectionManager;
	public static Database database;
	/**
	 * 分页查询
	 * @param pageBean
	 * @param table 表名
	 * @param field 字段名
	 * @param order 排序
	 * @param where 条件
	 * @throws DataException 
	 * @throws SQLException 
	 */
	public void dataPage(Connection conn, PageBean<Map<String, Object>> pageBean, String table, String field, String order, String condition) throws SQLException{
		List<Map<String,Object>> resultlist = new ArrayList<Map<String,Object>>();
		List<Object> outParameterValues = new ArrayList<Object>();
		long curPage =  pageBean.getPageNum();
		Database.executeProcedure(conn, "pr_page", resultlist, outParameterValues, new Parameter[]{new Parameter(Types.VARCHAR,ParameterDirection.IN,table),
				new Parameter(Types.VARCHAR,ParameterDirection.IN,field),new Parameter(Types.BIGINT,ParameterDirection.IN,pageBean.getPageSize()),
				new Parameter(Types.VARCHAR,ParameterDirection.IN,pageBean.getPageNum()),new Parameter(Types.VARCHAR,ParameterDirection.IN,order),
				new Parameter(Types.VARCHAR,ParameterDirection.IN,condition),new Parameter(Types.BIGINT, ParameterDirection.OUT, 0)});
		//记录数
		long count = (Long) outParameterValues.get(0);
		boolean result = pageBean.setTotalNum(count);
		pageBean.setPage(resultlist);
	}
	public static ConnectionManager getConnectionManager() {
		return connectionManager;
	}
	public static void setConnectionManager(ConnectionManager connectionManager) {
		BaseService.connectionManager = connectionManager;
	}
	public static Database getDatabase() {
		return database;
	}
	public static void setDatabase(Database database) {
		BaseService.database = database;
	}

}
