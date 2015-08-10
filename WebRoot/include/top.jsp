<%@page import="com.sun.org.apache.xml.internal.serialize.Printer"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/include/taglib.jsp" %>
<link rel="shortcut icon" href="favicon.ico">
<div class="ui_f_btn clearfix">
	<s:if test="#session.user!=null"><a href="logout.do" class="ui_l1">退出</a></s:if>
	<s:else>
		<a href="login.do" class="ui_l1">登录</a>
    	<a href="注册.html" class="ui_l2">注册</a>
	</s:else>
    <a class="ui_l3">在线客服</a>
</div>

<!--top bengin-->
<div class="ui_top">
	<Div class="ui_head ui_content">
    	<a href="index.do" class="logo fn_left"><img src="images/logo.png" /></a>
        <ul class="ui_nav clearfix fn_left">
        	<li><a href="index.do">首页</a></li>
            <li><a href="#">模块一</a></li>
            <li><a href="#">模块二</a></li>
            <li><a href="#">模块三</a></li>
            <li><a href="myhome.do">个人中心</a></li>
            <li><a href="#">模块四</a></li>
            <li><a href="#">模块五</a></li>
            <li><a href="#">模块六</a></li>
        </ul>
    </Div>
</div>