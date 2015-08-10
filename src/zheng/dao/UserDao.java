package zheng.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import zheng.data.Database;


public class UserDao {
	public List<Map<String,Object>> queryUserById(Connection conn,long id) throws SQLException{
		String sqlstr = "select id,username,email from t_user where id="+id;
		List<Map<String,Object>> userlist = Database.executeQuery(conn, sqlstr);
		return userlist;
	}
}
