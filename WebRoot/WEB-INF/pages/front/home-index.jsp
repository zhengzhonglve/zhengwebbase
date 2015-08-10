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
	<jsp:include page="/include/left.jsp"></jsp:include>
    <div class="ui_account_r fn_right clearfix">
    	<!--账户信息 开始-->
    	<Div class="ui_zh_info clearfix">
        	<Div class="ui_zh_info1 fn_left clearfix">
            	<h4>您好，<Em class="org">Hanson</Em></h4>
                <div class="clearfix">
                	<div class="ui_zh_tx fn_left mr20"><A><img src="images/pic01.png" width="113" height="113" /></A></div>
                    <div class="ui_zh_xx fn_left">
                    	<p>信用积分：<img src="images/tt1.png" /><span>会员积分：<img src="images/ico16.png" /></span></p>
                        <p>注册时间： 2014-06-18 </p>
                        <p>会员到期：2015-06-18 17:44:03</p>
                        <p>最后登录IP：112.95.172.43</p>
                    </div>
                </div>
            </Div>
            <Div class="ui_zh_info2 fn_left clearfix">
            	<p>信用额度：<em class="org">5000</em></p>
                <p>人统计：<i class="org">0</i> 条借款记录</p>
                <p><i class="org" style="padding-left:55px;">0 </i>条投标记录</p>
            </div>
        </Div>
        <!--账户信息 结束-->
        <!--温馨提示 开始-->
        <div class="myhome_tips clearfix mt15">
            <dl class="clearfix">
                <dt>温馨提示：</dt>
                <dd>未读站内信<a href="#" class="org">（0）</a>封</dd>
                <dd>等待审核借款<a href="#" class="org">（0）</a>个</dd>
                <dd>本月待还款<a href="#" class="org">（0）</a>个</dd>
                <dd>本月待收款<a href="#" class="org">（0）</a>个</dd>
                <dd>逾期待还款<a href="#" class="org">（0）</a>个</dd>
                <dd>上传资料<a href="#" class="org">（0）</a></dd>
            </dl>
        </div>
        <!--温馨提示 结束-->
        <!--快捷通道 开始-->
        <div class="td_box">
            <ul class="clearfix">
                <li>
                    <a href="#">
                       <img src="images/t1.png" />
                       <span>我要充值</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="images/t2.png" />
                        <span>我要贷出</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="images/t3.png" />
                        <span>债权转让</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="images/t4.png" />
                        <span>我要还款</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="images/t5.png" />
                        <span>待收款</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="images/t6.png" />
                        <span>流水资金</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="images/t7.png" />
                        <span>我要借款</span>
                    </a>
                </li>
            </ul>
        </div>
        <!--快捷通道 结束-->
        <!--账户详情 开始-->
        <table width="100%" cellpadding="0" cellspacing="0" class="zh_table mt20">
            <tr>
                <th class="th1" colspan="3" align="left">账户总汇：</th>
            </tr>
            <tr>
                <td>账户总额：￥0.00</td>
                <td>可用余额：￥0.00</td>
                <td>冻结金额：￥0.00</td>
            </tr>
            <tr>
                <td>总收益：￥0.00</td>
                <td>利息收益：￥0.00</td>
                <td>其他收益：￥0.00</td>
            </tr>
            <tr>
                <th class="th1" colspan="3" align="left">投资总汇：</th>
            </tr>
            <tr>
                <td>已收总额：￥0.00</td>
                <td>已收本金：￥0.00</td>
                <td>已收利息：￥0.00</td>
            </tr>
            <tr>
                <td>待收总额：￥0.00</td>
                <td>待收本金：￥0.00</td>
                <td>待收利息：￥0.00</td>
            </tr>
            <tr>
                <th class="th1" colspan="3" align="left">借款总汇：</th>
            </tr>
            <tr>
                <td>已收总额：￥0.00</td>
                <td>已收本金：￥0.00</td>
                <td>已收利息：￥0.00</td>
            </tr>
            <tr>
                <td>待收总额：￥0.00</td>
                <td>待收本金：￥0.00</td>
                <td>待收利息：￥0.00</td>
            </tr>
            <tr>
                <th class="th1" colspan="3" align="left">额度总汇：</th>
            </tr>
            <tr>
                <td>借款总额度：￥3000.00</td>
                <td>可用额度：￥3000.00</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <th class="th1" colspan="3" align="left">最近还款：</th>
            </tr>
            <tr>
                <td>最近还款日：￥3000.00</td>
                <td>最近还款金额：￥3000.00</td>
                <td>&nbsp;</td>
            </tr>
        </table>
        <!--账户详情 结束-->
    </div>
</div>
<jsp:include page="/include/footer.jsp"></jsp:include>

<script type="text/javascript">
$(function(){
	dqzt(4);
});
</script>
</body>
</html>
