<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- 头部 -->
<div style="width:100%; height:100%; background:#000; filter:alpha(opacity=30); opacity:0.3; z-index:10; position:fixed; display:none;" id="hiddenshow"></div>

<div class="xn_c_top_01">
  <div class="xn_c_logo"></div>
  <div class="xn_c_top_right">
    <span class="xn_c_top_right_t1">欢迎</span>
    <span class="xn_c_top_right_t1">普通管理员</span>
    <span class="xn_c_top_right_t1 xn_c_top_right_admin"></span>
    <span class="xn_c_top_right_t1">的到来!</span>
    <span class="xn_c_top_right_link">
      <a href="#">用户中心</a>
    <span>|</span>
      <a href="javascript:loginOut();" class="xn_c_top_right_a2">安全退出</a>
    </span>
    <div class="xn_c_top_right_t2">
      <span>权限组：</span>
      <span></span>
      <span id="date"></span>
      <span id="week"></span>
	  <span id="time"></span>
    </div>
    <div class="xn_c_top_right_t3">
      <span>登录IP： </span>
      <span></span>
      <span>上次登录IP : </span>
      <span> </span>
    </div>
  </div>
</div>
<div class="xn_c_top_02">
  <div class="top_span" id="mg_index"><a href="#">首页管理</a></div>
  <div class="top_span" id="mg_web">
  <a href="#">平台内容管理</a>
  </div>
  <div class="top_span" id="mg_bid"><a href="#">借款标管理</a></div>
  <div class="top_span" id="mg_account"><a href="#">账单催收</a></div>
  <div class="top_span" id="mg_usr"><a href="#">会员管理</a></div>
  <div class="top_span" id="mg_bill"><a href="#">财务管理</a></div>
  <div class="top_span" id="mg_seo"><a href="#">平台推广</a></div>
  <div class="top_span" id="mg_datasta"><a href="#">数据统计</a></div>
  <div class="top_span" id="mg_sys"><a href="#">系统设置</a></div>
  
</div>
<script type="text/javascript" language="javascript">
function loginOut() {
		if (confirm("是否确定要退出？")) {
			window.parent.location = "adminLoginOut.do";
		}
	}
</script>
<!-- 头部end -->