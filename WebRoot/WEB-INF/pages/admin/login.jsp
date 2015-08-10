<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>管理首页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<jsp:include page="frame/common.jsp"></jsp:include>
	<script type="text/javascript">

			$(function(){
				$(".login_code").val("");
				$(window).bind('keyup', function(event){
				   if (event.keyCode=="13"){
					   check();
				   }
				});
			});

			function check(){
				$("#form1").submit();
			}


			function loadActiveX(){
                window.open("../Setup.exe");
                alert("温馨提示：下载完控件后，请刷新页面");
				}
			
			//初始化
			function switchCode(){
				var timenow = new Date(); 
				$("#codeNum").attr("src","imageCode.do?pageId=adminlogin&d="+timenow);
			}
			//判断验证码是否过期
			function validatorCodeIsExpired(){
				var param = {};
				param["pageId"] = "adminlogin";
				$.post("codeIsExpired.do",param,function(data){
					 if(data == 1){
					 	alert("验证码已过期");
					 	switchCode();
					 	return ;
					 	
					 }
					$("#loginForm").submit();
				});

			}
	</script>
</head>
<body style=" background:url(../images/admin/login_bg.png) top;">
<s:if test='#request.uMaps.isOpen == "1"'>
	  <object
      id="eims"
	  classid="clsid:2D37D5F7-B18B-4E8E-8B3C-F26171922C16"
	  codebase="../ActiveLoginProj1.ocx#version=1,0,0,0"
	  width=0
	  height=0
	  align=center
	  hspace=0
	  vspace=0 ></object>
<input type="hidden" value="checkutool" name="" id="utoolcheck" />
 </s:if>
    <form id="form1" action="supervisorlogin.do" method="post">
         <div style="width: 100%; overflow: hidden;">
            <div style="float: left; width: 100%; text-align: left; padding:120px 0px 5px 0px;">
                
            </div>
          </div>
        <div style="width:518px; margin:0px 0px 0px 0px; margin-left: auto; margin-right: auto;
            overflow: hidden;">
            <div style= " width: 518px; overflow:hidden;">
                <div style="margin-left: auto; margin-right: auto;">
                    <div style="background-image: url(../images/admin/login_kuang_bg.png); overflow:hidden; height:259px;">
                        <table width="518" border="0" align="center" cellpadding="0" cellspacing="0">
                        	<tr height="40"></tr>
                            <tr>
                                <td  width="100" align="right" style="color:#fff; font-size:14px; font-weight:bold;">账号：</td>
                                <td width="300">
                                	<s:textfield id="userName" name="paramMap.userName" theme="simple" maxlength="25" cssClass="login_text" cssStyle="width: 280px"></s:textfield>
                                </td>
                            </tr>
                            <tr height="20">
                            	<td></td>
                                <td><span style="color: red; font-size:12px;"><s:fielderror fieldName="paramMap.userName" /></span></td>
                            </tr>
                            <tr>
                                <td  width="100" align="right" style="color:#fff; font-size:14px; font-weight:bold;">密码：</td>
                                <td>
                                	<s:password id="password" name="paramMap.password" cssClass="login_text" cssStyle="width: 280px" theme="simple" maxlength="20"></s:password>
                                </td>
                            </tr>
                            <tr height="20">
                            	<td></td>
                                <td><span style="color: red; font-size:12px;"><s:fielderror fieldName="paramMap.password" /></span></td>
                            </tr>
                            <tr>
                                <td width="100" align="right" style="color:#fff; font-size:14px; font-weight:bold;">验证码：</td>
                                <td valign="bottom">
                                	<s:textfield  name="paramMap.code" cssClass="login_text" theme="simple" cssStyle="width: 120px"/>
                                    <img src="imageCode.do?pageId=adminlogin" title="点击更换验证码" style="cursor: pointer; vertical-align:-4px; *vertical-align:-1px; margin-left:10px;" id="codeNum" width="58px" height="24px" onclick="javascript:switchCode()"></img>
                            	</td>
                            </tr>
                            <tr height="20">
                            	<td></td>
                                <td><span style="color: red; font-size:12px;"><s:fielderror fieldName="paramMap.code" /></span></td>
                            </tr>
                            <tr>
                            	<td></td>
                                <td style="padding: 25px 0px 0px 0px;">
                                    <input type="button" value="确认" style="background:url(../images/admin/login_menu.png); width:100px; height:32px; line-height:32px; color:#fff; font-size:14px; font-weight:bold;" onclick="check()"/>
                                 </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>

