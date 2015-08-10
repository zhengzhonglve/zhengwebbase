package zheng.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;
public class ReadProperty {
	 private Properties property;
	  private String filePath;

	  public ReadProperty()
	    throws UnsupportedEncodingException
	  {
	    this("config.properties");
	  }

	  public ReadProperty(String propertyFileName)
	    throws UnsupportedEncodingException
	  {
	    InputStream is = null;
	    this.property = new Properties();
	    this.filePath = URLDecoder.decode(getClass().getResource("/").getPath() + propertyFileName, "UTF-8");
	    try
	    {
	      is = new FileInputStream(this.filePath);
	      this.property.load(is);
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	      try
	      {
	        is.close();
	      }
	      catch (IOException ie) {
	        ie.printStackTrace();
	      }
	    }
	    finally
	    {
	      try
	      {
	        is.close();
	      }
	      catch (IOException e) {
	        e.printStackTrace();
	      }
	    }
	  }

	  public ReadProperty(String propertyFilePath, String propertyFileName)
	    throws UnsupportedEncodingException
	  {
	    InputStream is = null;
	    this.property = new Properties();
	    this.filePath = URLDecoder.decode(propertyFilePath + propertyFileName, "UTF-8");
	    try
	    {
	      is = new FileInputStream(this.filePath);
	      this.property.load(is);
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	      try
	      {
	        is.close();
	      }
	      catch (IOException ie) {
	        ie.printStackTrace();
	      }
	    }
	    finally
	    {
	      try
	      {
	        is.close();
	      }
	      catch (IOException e) {
	        e.printStackTrace();
	      }
	    }
	  }

	  public String read(String key)
	  {
	    return this.property.getProperty(key);
	  }

	  public void write(String key, String value)
	  {
	    InputStream is = null;
	    try
	    {
	      is = new FileInputStream(this.filePath);
	      this.property.clear();
	      this.property.load(is);
	    }
	    catch (IOException e) {
	      e.printStackTrace();

	      return;
	    } finally {
	      try {
	        is.close();
	      }
	      catch (IOException e) {
	        e.printStackTrace();
	      }
	    }

	    OutputStream os = null;
	    this.property.setProperty(key, value);
	    try
	    {
	      os = new FileOutputStream(this.filePath);
	      this.property.store(os, "");
	      os.flush();
	    } catch (Exception e) {
	      e.printStackTrace();
	      try
	      {
	        os.close();
	      }
	      catch (IOException ie) {
	        ie.printStackTrace();
	      }
	    }
	    finally
	    {
	      try
	      {
	        os.close();
	      }
	      catch (IOException e) {
	        e.printStackTrace();
	      }
	    }
	  }
	  
}
