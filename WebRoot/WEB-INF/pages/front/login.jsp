<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<jsp:include page="/include/common.jsp"></jsp:include>
</head>
<body>
<!-- 头部 -->
<jsp:include page="/include/top.jsp"></jsp:include>
<div class="ui_content mt40 clearfix">
	<div class="login_box clearfix">
        <h4>欢迎登录！<a href="注册.html" class="aa1">免费注册</a></h4>
        <table width="100%">
            <tr>
                <th width="17%" align="right">邮箱／手机／账号：</th>
                <td width="83%" valign="middle"><input type="text" class="test7" /></td>
            </tr>
            <tr style="display:none;">
                <th align="right">&nbsp;</th>
                <td valign="middle">*请输入用户名或邮箱地址</td>
            </tr>
            <tr>
                <th align="right">密码：</th>
                <td valign="middle"><input type="password" class="test7" /></td>
            </tr>
            <tr style="display:none;">
                <th align="right">&nbsp;</th>
                <td valign="middle">*请輸入您的密码</td>
            </tr>
            <tr>
                <th align="right">验证码：</th>
                <td valign="middle">
					<input type="text" class="h_yzm3" name="paramMap.code"
						id="code" />
					<img src="supervisor/imageCode.do?pageId=userlogin" title="点击更换验证码"
						style="vertical-align:middle;" id="codeNum" width="46" height="18"
						onclick="javascript:switchCode()" /> &nbsp;&nbsp; <a href="javascript:void()" onclick="switchCode()" style="color: blue;">换一换?</a>
				</td>
            </tr>
            <tr style="display:none;">
                <th>&nbsp;</th>
                <td>*请输入验证码</td>
            </tr>
            <tr>
                <th></th>
                <td><input type="checkbox"  class="check"  /> 自动登录&nbsp;&nbsp;&nbsp;&nbsp;<a href="忘记密码.html" style="color:#136dad;">忘记密码？</a></td>
            </tr>
            <tr>
                <th>&nbsp;</th>
                <td><input id="btn_login" type="submit" class="btn19" value="登 录" /></td>
            </tr>
        </table>
    </div>
</div>
<jsp:include page="/include/footer.jsp"></jsp:include>

<script type="text/javascript">
$(function(){
	dqzt(4);
	//登陆提交
	$("#btn_login").click(function(){
	    login();  
	  });
});

function switchCode(){
	var timenow = new Date();
	$("#codeNum").attr("src","supervisor/imageCode.do?pageId=userlogin&d="+timenow);
}

function login(){
	$('#btn_login').attr('value','登录中...');
	 var param = {};
		param["paramMap.username"] = "superzheng";
		$.post("logining.do",param,function(data){
			if(data.code==1){
				var afterLoginUrl='${session.afterLoginUrl}';
      	        if(afterLoginUrl != ''){
				   window.location.href='${session.afterLoginUrl}';
      	        }else{
				   window.location.href='myhome.do';
      	        }
			}else{
				alert(data.msg);
				$("#btn_login").attr('value','登录');
			}
		});
}


</script>
</body>
</html>
