<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title></title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
  <jsp:include page="common.jsp"></jsp:include>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div class="xn_c_contentwarp">
欢迎来到zheng的后台
</div>
<jsp:include page="bottom.jsp"></jsp:include>
<script type="text/javascript">
  $(function() {
	
  });

   //（下面注释的代码只有在测试的时候注释掉）
  //$(window).bind("click",clickthing); 
  
	
  function updateTime() {
    var date = new Date();
	$("#date").html(date.format("yyyy年MM月dd日"));
	$("#time").html(date.format("HH:mm:ss"));
	$("#week").html(date.format("EEE"));
  }
</script>
</body>
</html>