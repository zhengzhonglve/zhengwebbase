package zheng.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;


public class TestDataBase {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = Database.getConnection();
		String command = "select id ,username from t_user";
		List<Map<String,Object>> resultlist = new ArrayList<Map<String,Object>>();
		try {
			/*查询
			List<HashMap<String,Object>> userlist = Database.executeQuery(conn, command);
			System.out.println(userlist);*/
			
			/*存储过程
			List<Object> outParameterValues = new ArrayList<Object>();
			int result = Database.executeProcedure(conn, "`pr_examine`", resultlist, outParameterValues, new Parameter[]{new Parameter(Types.BIGINT,ParameterDirection.IN,2)});
			System.out.println(resultlist);*/
			
			/*修改插入等待
			command = "update t_user set username = 'zheng' where id = 1 ";
			long result = Database.executeNonQuery(conn,command);*/
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		
	}
	

}
