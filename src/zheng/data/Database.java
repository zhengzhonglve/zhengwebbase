package zheng.data;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
	private static Log log = LogFactory.getLog(Database.class);
	protected static ConnectionManager cm = ConnectionManager.getInstance();
	
	public static Connection getConnection()throws SQLException{
	    Connection conn = cm.getConnection();
	    conn.setAutoCommit(false);
	    return conn;
	}
	
	public static void rollback(Connection conn)throws SQLException{
		conn.rollback();
	}
	
	  public static void commit(Connection conn)
	    throws SQLException
	  {
	    conn.commit();
	  }
	  /*执行非查询sql*/
	  public static long executeNonQuery(Connection conn, String command, Parameter... params)throws SQLException{
	    PreparedStatement statement = null;
	    if (ConnectionManager.outputStatementToLogger) {
	      log.info("正在执行数据库命令： " + command + ", 命令有 " + (params == null ? 0 : params.length) + " 个参数。");
	    }
	    try
	    {
	      statement = conn.prepareStatement(command,1);
	    } catch (SQLException e) {
	      statement = conn.prepareStatement(command);
	    }

	    setParameter(statement, params);

	    long result = statement.executeUpdate();
	    try {
	      ResultSet rs = statement.getGeneratedKeys();

	      if ((rs != null) && (rs.next())) {
	        result = rs.getLong(1);
	      }
	    }
	    catch (Exception localException)
	    {
	    }
	    statement.close();

	    return result;
	  }
	  
	  /*查询返回list*/
	  public static List<Map<String,Object>> executeQuery(Connection conn, String command)
	    throws SQLException
	  {
	    PreparedStatement statement = conn.prepareStatement(command);

	    if (ConnectionManager.outputStatementToLogger) {
	      log.info("正在执行数据库命令： " + command);
	    }
	    
	    ResultSet rs = statement.executeQuery();
	    List<Map<String, Object>> resultList = resultSetToList(rs);
	    rs.close();
	    statement.close();
	    return resultList;
	  }
	  
	  /*执行数据库函数*/
	  public static Object executeFunction(Connection conn, String FunctionName, Parameter returnParameter, Parameter[] params)
	    throws SQLException
	  {
	    String command = "{ ? = call " + FunctionName + "(";

	    for (int i = 0; i < params.length; i++) {
	      command = command + (i > 0 ? ", ?" : "?");
	    }

	    command = command + ") }";

	    if (ConnectionManager.outputStatementToLogger) {
	      log.info("正在执行数据库命令： " + command + ", 命令有 " + (params == null ? 0 : params.length) + " 个参数。");
	    }

	    CallableStatement statement = conn.prepareCall(command);
	    setParameter(statement, returnParameter, params);
	    statement.execute();
	    Object object = statement.getObject(1);
	    statement.close();

	    return object;
	  }
	  
	  /*执行数据库存储过程*/
	  public static int executeProcedure(Connection conn, String ProcedureName, List<Map<String,Object>> resultlist, List<Object> outParameterValues, Parameter[] params)
	    throws SQLException
	  {
	    String command = "{ call " + ProcedureName + "(";

	    for (int i = 0; i < params.length; i++) {
	      command = command + (i > 0 ? ", ?" : "?");
	    }

	    command = command + ") }";

	    if (ConnectionManager.outputStatementToLogger) {
	      log.info("正在执行数据库命令： " + command + ", 命令有 " + (params == null ? 0 : params.length) + " 个参数。");
	    }

	    CallableStatement statement = conn.prepareCall(command);
	    setParameter(statement, params);
	    statement.execute();

	    if (resultlist != null) {
	      ResultSet rs = null;
	        rs = statement.getResultSet();
	        if (rs != null)
	        {
	        	resultlist = resultSetToList(rs,resultlist);
	        }
	      if (rs != null) {
	        rs.close();
	      }
	    }

	    fillOutParameterValues(statement, outParameterValues, 1, params);
	    statement.close();

	    return 0;
	  }
	  
	  /*将resultset转化为List<Map>*/
	  public static List<Map<String,Object>> resultSetToList(ResultSet rs,List<Map<String, Object>> resultList) throws SQLException{
		    ResultSetMetaData rsmd = rs.getMetaData();
		    int columnCount = rsmd.getColumnCount();
		    while(rs.next()){
		    	HashMap<String,Object> map = new HashMap<String,Object>();
		    	for(int i = 0;i < columnCount; i++){
		    		map.put(rsmd.getColumnLabel(i+1), rs.getObject(i+1));
		    	}
		    	resultList.add(map);
		    }
		    return resultList;
	  }
	  
	  public static List<Map<String,Object>> resultSetToList(ResultSet rs) throws SQLException{
		    ResultSetMetaData rsmd = rs.getMetaData();
		    int columnCount = rsmd.getColumnCount();
		    List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		    while(rs.next()){
		    	HashMap<String,Object> map = new HashMap<String,Object>();
		    	for(int i = 0;i < columnCount; i++){
		    		map.put(rsmd.getColumnLabel(i+1), rs.getObject(i+1));
		    	}
		    	resultList.add(map);
		    }
		    return resultList;
	  }
	  
	  protected static void setParameter(PreparedStatement statement, Parameter[] params)
	    throws SQLException
	  {
	    if (params.length == 0) {
	      return;
	    }

	    for (int i = 0; i < params.length; i++) {
	      if (params[i].direction != ParameterDirection.IN) {
	        throw new SQLException("Not contain parameters of type OUT.");
	      }

	      statement.setObject(i + 1, params[i].value);
	    }
	  }

	  protected static void setParameter(CallableStatement statement, Parameter[] params)
	    throws SQLException
	  {
	    if (params.length == 0) {
	      return;
	    }

	    for (int i = 0; i < params.length; i++) {
	      if ((params[i].direction == ParameterDirection.OUT) || 
	        (params[i].direction == ParameterDirection.INOUT)) {
	        statement.registerOutParameter(i + 1, params[i].type);
	      }

	      if ((params[i].direction == ParameterDirection.IN) || 
	        (params[i].direction == ParameterDirection.INOUT))
	        statement.setObject(i + 1, params[i].value);
	    }
	  }

	  protected static void setParameter(CallableStatement statement, Parameter returnParameter, Parameter[] params)
	    throws SQLException
	  {
	    if ((returnParameter == null) || 
	      (returnParameter.direction != ParameterDirection.RETURN)) {
	      throw new SQLException(
	        "The returnParameter can not be null, and return type must be.");
	    }

	    statement.registerOutParameter(1, returnParameter.type);

	    if (params.length == 0) {
	      return;
	    }

	    for (int i = 0; i < params.length; i++) {
	      if ((params[i].direction == ParameterDirection.OUT) || 
	        (params[i].direction == ParameterDirection.INOUT)) {
	        statement.registerOutParameter(i + 2, params[i].type);
	      }

	      if ((params[i].direction == ParameterDirection.IN) || 
	        (params[i].direction == ParameterDirection.INOUT))
	        statement.setObject(i + 2, params[i].value);
	    }
	  }
	  
	  protected static void fillOutParameterValues(CallableStatement statement, List<Object> outParameterValues, int offset, Parameter[] params)throws SQLException{
	    if ((outParameterValues == null) || (params.length == 0)) {
	      return;
	    }
	    for (int i = 0; i < params.length; i++)
	      if ((params[i].direction == ParameterDirection.OUT) || 
	        (params[i].direction == ParameterDirection.INOUT))
	        outParameterValues.add(statement.getObject(i + offset));
	  }

	  
}
