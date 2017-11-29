require('jquery');
require('css!gotop.css');
/*
 * 回到页面顶部
 */
$(function(){
	if($("#gotop").size() == 0)
	    $("body").append("<div class='gotopOutside' id='gotop'> "
		+ "<div class= 'gotopInside' >"
		+ "<img src='../../img/top.png'/>"
		+ "<p class='gotopFont'>返回顶部</p>"
		+ "</div></div>");

	var speed = 300;
	if($.browser.msie && parseInt($.browser.version) < 9)
		speed = 0;
	
	$(window).scroll(function(){  //只要窗口滚动,就触发下面代码 
		var scrollt = document.documentElement.scrollTop + document.body.scrollTop; //获取滚动后的高度 
		if( scrollt > 200 ){  //判断滚动后高度超过200px,就显示  
			$("#gotop").fadeIn(speed); //淡出     
		}else{      
			$("#gotop").stop().fadeOut(speed); //如果返回或者没有超过,就淡入.必须加上stop()停止之前动画,否则会出现闪动   
		}
	});

	$("#gotop").click(function(event){ //当点击标签的时候,使用animate在200毫秒的时间内,滚到顶部
		event.preventDefault();
		$("html,body").animate({scrollTop:"0px"}, speed);
	});

});

return function(where){
	var top = where ? (parseInt(where) || $(where).offset().top) : 0;
	$("html,body").animate({scrollTop:top+"px"}, 300);
};