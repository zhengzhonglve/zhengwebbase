package zheng.safe;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

public class Utility
{
  private static Map<String, String> sql_keyword_tokens = new HashMap();

  private static Pattern sql_keyword_pattern =  null;

  static
  {
    sql_keyword_tokens.put("update", "ｕｐｄａｔｅ");
    sql_keyword_tokens.put("drop", "ｄｒｏｐ");
    sql_keyword_tokens.put("delete", "ｄｅｌｅｔｅ");
    sql_keyword_tokens.put("exec", "ｅｘｅｃ");
    sql_keyword_tokens.put("create", "ｃｒｅａｔｅ");
    sql_keyword_tokens.put("execute", "ｅｘｅｃｕｔｅ");
    sql_keyword_tokens.put("truncate", "ｔｒｕｎｃａｔｅ");
    sql_keyword_tokens.put("insert", "ｉｎｓｅｒｔ");

    String patternString = "((" + StringUtils.join(sql_keyword_tokens.keySet(), "[\t\n\r\f\\s+　])|(") + "[\t\n\r\f\\s+　]))";
    sql_keyword_pattern = Pattern.compile(patternString, 2);
  }

  public static String post(String url, String parameterList)
  {
    OutputStreamWriter out = null;
    StringBuilder result = new StringBuilder();
    try {
      URL urlTemp = new URL(url);
      URLConnection connection = urlTemp.openConnection();

      connection.setDoOutput(true);

      out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
      out.write(parameterList);
      out.flush();

      String line = "";

      InputStream is = connection.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

      while ((line = br.readLine()) != null)
        result.append(line);
    }
    catch (Exception e) {
      e.printStackTrace();

      if (out != null)
        try {
          out.close();
        } catch (IOException oe) {
          oe.printStackTrace();
        }
    }
    finally
    {
      if (out != null) {
        try {
          out.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return result.toString();
  }

  public static String getDomainName(HttpServletRequest request)
  {
    String domainName = request.getServerName();

    return domainName;
  }

  public static String getRootPath(HttpServletRequest request)
  {
    String rootPath = request.getScheme() + "://" + request.getServerName() + (request.getServerPort() == 80 ? "" : new StringBuilder(":").append(request.getServerPort()).toString()) + request.getContextPath() + "/";

    return rootPath;
  }

  public static String filteSqlInfusion(String input)
  {
    return filteSqlInfusion(input, Boolean.valueOf(true));
  }

  public static String filteSqlInfusion(String input, Boolean replaceSingleQuoteMark)
  {
    if ((input == null) || (input.trim().isEmpty())) {
      return input;
    }

    if (input.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")) {
      return input;
    }

    if (replaceSingleQuoteMark.booleanValue()) {
      input = input.replace('\'', '’');
    }

    Matcher matcher = sql_keyword_pattern.matcher(input);
    StringBuffer sb = new StringBuffer();

    while (matcher.find()) {
      String str = matcher.group(1);
      String token = str.substring(0, str.length() - 1);
      str = str.substring(str.length() - 1);
      matcher.appendReplacement(sb, (String)sql_keyword_tokens.get(token.toLowerCase()) + str);
    }

    matcher.appendTail(sb);

    return sb.toString();
  }
}