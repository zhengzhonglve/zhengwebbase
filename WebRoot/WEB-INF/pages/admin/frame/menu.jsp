﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>管理首页</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<jsp:include page="common.jsp"></jsp:include>

	<script type="text/javascript">
		if('${session.index}'==-1){
			window.top.main.location.href="main.do";
		}
		$(function(){
			$(".munes li").click(function(){
			$(".munes li").attr("class","");
			$(this).attr("class","cur");
			})
		})
	</script>
	</head>
	<body style="width: 100%; margin-top:20px; padding: 0px; background:#fff url(../images/admin/main-left.gif) 147px top repeat-y; *background:#fff url(../images/admin/main-left.gif) 146px top repeat-y; min-height:300px;">
		<form id="form1" style="padding:0; margin:0">
			<div id="left">
				<table border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<s:iterator value="#session.adminRoleMenuList.{?#this.rightsId==#session.index}" var="bean" status="sta">
								<table border="0" cellspacing="0" cellpadding="0">
									<tr style="cursor: pointer;"onclick="showsubmenu(${sta.index})">
										<td height="33" class="menu_top_a">
											${bean.summary }
										</td>
										<td align="left">
										</td>
									</tr>
								</table>
							</s:iterator>
							<div id="submenu${sta.index}" class="munes">
                            <ul>
								<s:iterator
									value="#session.adminRoleMenuList.{?#this.parentId==#session.index}" var="sBean">
										<li>
                                            <a href="${sBean.action }"
                                                target="main"><span class="point">&raquo;</span>${sBean.summary }</a>
										</li>
								</s:iterator>
								<li>
                                    <a href="zheng.do" target="main"><span class="point">&raquo;</span>111111</a>
								</li>
								<li>
                                    <a href="zheng.do" target="main"><span class="point">&raquo;</span>222222</a>
								</li>
                            </ul>
                                  
							</div>
							  
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>
