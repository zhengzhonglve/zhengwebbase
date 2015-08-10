package zheng.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import zheng.base.BaseService;
import zheng.base.PageBean;
import zheng.dao.UserDao;
import zheng.data.Database;

public class UserService extends BaseService{
	public UserDao userdao;
	/**
	 * 分页查询user
	 * @param pageBean
	 * @throws SQLException
	 */
	public void queryUsersPage(PageBean<Map<String, Object>> pageBean) throws SQLException{
		Connection conn = Database.getConnection();
		try{
			dataPage(conn,pageBean,"t_user"," id,username,email ","","");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
	}
	public UserDao getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	/**
	 * 根据id查询user
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> queryUserById(long id) throws Exception{
		Connection conn = Database.getConnection();
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			List<Map<String,Object>> userlist = userdao.queryUserById(conn,id);
			if(userlist != null && userlist.size() > 0){
				map = userlist.get(0);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			conn.close();
		}
		return map;
	}
	
}
