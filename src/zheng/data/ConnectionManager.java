package zheng.data;

import org.dom4j.io.SAXReader;
import com.mchange.v2.c3p0.DataSources;
import java.io.File;
import java.net.URLDecoder;
import org.dom4j.Document;
import org.dom4j.Element;
import java.sql.Connection;
import java.sql.SQLException;

import zheng.util.Convert;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionManager {
	private static ConnectionManager instance;
	  public static String owner = "";
	  public static boolean outputStatementToLogger = false;

	  public static String jdbcUrl = "";
	  private ComboPooledDataSource ds;
	  static
	  {
	    try
	    {
	      SAXReader saxReader = new SAXReader();
	      String path = Thread.currentThread().getContextClassLoader().getResource("").toString().substring(6).replace("%20", " ") + "c3p0-config.xml";
	      path = URLDecoder.decode(path, "utf-8");
	      Document document = saxReader.read(new File(path));
	      Element node = (Element)document.selectSingleNode("/c3p0-config/default-config/property[@name='owner']");
	      owner = node.getText();
	      node = (Element)document.selectSingleNode("/c3p0-config/default-config/property[@name='OutputStatementToLogger']");
	      outputStatementToLogger = Convert.strToBoolean(node.getText(), false);
	    } catch (Exception e) {
	      owner = "";
	      outputStatementToLogger = true;
	    }
	  }
	  
	  private ConnectionManager()throws Exception{
		    this.ds = new ComboPooledDataSource();
		    String jdbcUrl = this.ds.getJdbcUrl();
		    String user = this.ds.getUser();
		    String password = this.ds.getPassword();
		    /*这里可以对串加密*/
		    this.ds.setJdbcUrl(jdbcUrl);
		    this.ds.setUser(user);
		    this.ds.setPassword(password);
	  }
	  
	  public static final ConnectionManager getInstance()
	  {
	    if (instance == null) {
	      try {
	        instance = new ConnectionManager();
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }

	    return instance;
	  }
	  
	  public final synchronized Connection getConnection()
	  {
	    Connection conn = null;
	    try
	    {
	      conn = this.ds.getConnection();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return conn;
	  }

	  protected void finalize() throws Throwable {
	    DataSources.destroy(this.ds);
	    super.finalize();
	  }

	  public String getConnectionUser()
	  {
	    return this.ds.getUser();
	  }
}
