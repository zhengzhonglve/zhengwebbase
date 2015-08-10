package zheng.base;


import zheng.safe.Utility;
import zheng.util.Convert;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class Request
{
  private HttpServletRequest request;

  public Request(HttpServletRequest request)
  {
    this.request = request;
  }

  private String getString(String key, boolean isfilteSqlInfusion)
  {
    String value = this.request.getParameter(key);

    if ((value == null) || (value.isEmpty())) {
      return value;
    }

    if ((!isfilteSqlInfusion)) {
      return value;
    }

    return Utility.filteSqlInfusion(value);
  }

  public String getString(String key)
  {
    return getString(key, true);
  }

  public int getInt(String key, int defaultValue)
  {
    return Convert.strToInt(getString(key, false), defaultValue);
  }

  public long getLong(String key, long defaultValue)
  {
    return Convert.strToLong(getString(key, false), defaultValue);
  }

  public float getFloat(String key, float defaultValue)
  {
    return Convert.strToFloat(getString(key, false), defaultValue);
  }

  public double getDouble(String key, double defaultValue)
  {
    return Convert.strToDouble(getString(key, false), defaultValue);
  }

  public boolean getBoolean(String key, boolean defaultValue)
  {
    return Convert.strToBoolean(getString(key, false), defaultValue);
  }

  public Date getDate(String key, Date defaultValue)
  {
    return Convert.strToDate(getString(key, false), defaultValue);
  }

  public Date getDate(String key, String format, Date defaultValue)
  {
    return Convert.strToDate(getString(key, false), format, defaultValue);
  }
}
