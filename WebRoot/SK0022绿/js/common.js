$(function(){
	//选项卡
	$(".tab_meun ul li").click(function(){
		var $index=$(".tab_meun ul li").index(this);
		$(this).addClass("on").siblings().removeClass("on");
		$(".tab_content > div").eq($index).show().siblings().hide();
		})	
	$(".tab_meun ul li:first-child").addClass("on")
	
	//导航
	$(".ui_account_lbox dl:first").show();
	$(".ui_account_lbox h3").click(function(){
		var $dl=$(this).parent(".ui_account_lbox").find("dl")
		if($dl.is(":hidden")){
			$dl.slideDown();
			}
		else{
			$dl.slideUp();
			}
		})
	$(".h_ask li h4").click(function(){
		$(this).next(".h_ask_con").slideDown().parent("li").siblings().find(".h_ask_con").slideUp();
			})		
		
	})