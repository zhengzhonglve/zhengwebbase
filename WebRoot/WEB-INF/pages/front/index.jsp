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
<!--banner 开始-->
<div class="banner">
  <div id="container">
    <div id="example">
      <div id="slides">
        <div class="slides_container">
          <div class="prolist"><a title="" target="_blank"> <img src="images/banner1.jpg" width="1920" height="442" alt=""></a> </div>
          <div class="prolist"><a title="" target="_blank"> <img src="images/banner1.jpg" width="1920" height="442" alt=""></a> </div>
          <div class="prolist"><a title="" target="_blank"> <img src="images/banner1.jpg" width="1920" height="442" alt=""></a> </div>
          <div class="prolist"><a title="" target="_blank"> <img src="images/banner1.jpg" width="1920" height="442" alt=""></a> </div>
        </div>
        <div class="arrowbox"><a href="#" class="prev"></a> <a href="#" class="next"></a></div>
      </div>
    </div>
  </div> 
</div>
<script src="script/slides.min.jquery.js" type="text/javascript"></script>
<script src="script/tab_center.js" type="text/javascript"></script>
<script>
		$(function(){
			$('#slides').slides({
				preload: true,
				preloadImage: 'images/banner/loading.gif',
				play: 4000,
				pause: 2500,
				hoverPause: true
			});
		});
</script>
<!--banner 结束-->
<div class="ui_content mt45 clearfix">
	<div class="ui_lct0 fn_left clearfix">
    	<A>01.注册</A>
        <A class="ui_ccz">02.充值</A>
        <A>03.投资</A>
    </div>
    <div class="ui_lct1 fn_right clearfix">
    	<h5><strong>3226439.49</strong>元 (风险保证金总额)</h5>
        <p>当日支出:10.00    当日收入:719.97</p>
    </div>
</div>
<!--列表 开始-->
<Div class="ui_b_wrap mt45 clearfix">
	<div class="ui_b_list ui_content clearfix">
    	<h2 class="ui_hd2 clearfix"><Span>最新借款列表</Span><A class="more">更多</A></h2>
        <ul class="clearfix">
        	<li>
            	<h3><A href="标的详情.html">我要去澳门赌博没有钱 </A></h3>
                <Div class="ui_b_list_01">
                	<p class=" clearfix">
                    	<span>年利率<br /><em>￥ 10.00 %</em></span>
                        <span>借款期限<br /><em>1<i>个月</i></em></span>
                    </p>
                	<p class="mt20 clearfix">借款金额：￥ 2,000.00 元</p>
                </Div>
                <Div class="ui_b_list_02">
                	<div class="ui_b_list_02_l">
                    	<p>信用等级：AA</p>
                        <p>还需：2,000.00 元</p>
                    </div>
                    <div class="ui_b_list_02_r">
                        <p>50%</p>
                        <div class="ui_jd_box clearfix"><em class="fn_left">当前进度：</em><div class="ui_jd fn_left"><i style="width:50%"></i></div></div>
                    </div>
                </Div>
            </li>
            <li>
            	<h3><A href="标的详情.html">我要去澳门赌博没有钱 </A></h3>
                <Div class="ui_b_list_01">
                	<p class=" clearfix">
                    	<span>年利率<br /><em>￥ 10.00 %</em></span>
                        <span>借款期限<br /><em>1<i>个月</i></em></span>
                    </p>
                	<p class="mt20 clearfix">借款金额：￥ 2,000.00 元</p>
                </Div>
                <Div class="ui_b_list_02">
                	<div class="ui_b_list_02_l">
                    	<p>信用等级：AA</p>
                        <p>还需：2,000.00 元</p>
                    </div>
                    <div class="ui_b_list_02_r">
                        <p>50%</p>
                        <div class="ui_jd_box clearfix"><em class="fn_left">当前进度：</em><div class="ui_jd fn_left"><i style="width:50%"></i></div></div>
                    </div>
                </Div>
            </li>
            <li>
            	<h3><A href="标的详情.html">我要去澳门赌博没有钱 </A></h3>
                <Div class="ui_b_list_01">
                	<p class=" clearfix">
                    	<span>年利率<br /><em>￥ 10.00 %</em></span>
                        <span>借款期限<br /><em>1<i>个月</i></em></span>
                    </p>
                	<p class="mt20 clearfix">借款金额：￥ 2,000.00 元</p>
                </Div>
                <Div class="ui_b_list_02">
                	<div class="ui_b_list_02_l">
                    	<p>信用等级：AA</p>
                        <p>还需：2,000.00 元</p>
                    </div>
                    <div class="ui_b_list_02_r">
                        <p>50%</p>
                        <div class="ui_jd_box clearfix"><em class="fn_left">当前进度：</em><div class="ui_jd fn_left"><i style="width:50%"></i></div></div>
                    </div>
                </Div>
            </li>
        </ul>
    </div>
</Div>
<!--列表 结束-->
<div class="clearfix ui_content mt35">
	<h2 class="ui_hd2 clearfix"><Span>新闻动态</Span><A class="more">更多</A></h2>
    <ul class="ui_news00 clearfix">
    	<li><A href="#">继续坚持以数据积累为核心，建立更加完善的风险控制体系</A><span>2014.6.6</span></li>
        <li><A href="#">着国内经济发展，国民收入的增加以及借贷渠道的拓宽，互联网金融的蓬勃发展将</A><span>2014.6.6</span></li>
        <li><A href="#">资本合伙人郑庆生，人人友信创始合伙人张适时，挚信资本合伙人林宁，中国金融博物</A><span>2014.6.6</span></li>
        <li><A href="#">此轮融资将用于加强企业内部运营建设、优化产品服务等方面</A><span>2014.6.6</span></li>
    </ul>   
</div>
<jsp:include page="/include/footer.jsp"></jsp:include>

<script type="text/javascript">
$(function(){
	dqzt(0);
});
</script>
</body>
</html>
