$(document).ready(function() {
		$(".sidebar-menu").accordion({
			accordion:false,
			speed: 300,
			closedSign: 'glyphicon glyphicon-triangle-left',
			openedSign: 'glyphicon glyphicon-triangle-bottom'
		});
		//
		$(".navbarLogo").click(function(event){
			$("#rightContent").attr("src","views/common/homepage.html");
		})
		//全屏模式
		$("#slideToggle").on("click",function(event){
			event.stopPropagation();
			$.cookie("showLeftBar");
			if($("#rightside").hasClass("right-sideLs"))
			{
				$("#rightside").css("width",$(window).width()-$(".left-side").width());
				$("#rightside").removeClass("right-sideLs");
				$.cookie("showLeftBar","show");
				localStorage.showLeftBar="show";
			}
			else
			{
				$("#rightside").css("width",$(window).width());
				$("#rightside").addClass("right-sideLs");
				$.cookie("showLeftBar","hide");
				localStorage.showLeftBar="hide";
			}
			$(".left-side").toggle();
		})
		
		if($.cookie("showLeftBar") =="hide" || localStorage.showLeftBar == "hide")
		{
			$(".content-header").removeClass("content-headerLs");
			$("#rightside").addClass("right-sideLs");
			$(".left-side").hide();
		}
		//滚动条样式
		$(".left-side").niceScroll({cursorcolor:"#bcbcbc",cursorborder:"#bcbcbc",mousescrollstep:"60",scrollspeed:"80"});
		$("body").niceScroll({cursorcolor:"#bcbcbc",cursorborder:"#bcbcbc",mousescrollstep:"60",scrollspeed:"80"});
		
		var lastVisitNew=$.cookie("lastVisitNew");
		if(!lastVisitNew && window.localStorage)
			lastVisitNew=localStorage.localStorage;
		//首页
		var dfpage="views/common/homepage.html";
		if(lastVisitNew&&lastVisitNew.length>0)
			dfpage=lastVisitNew;
		$("#rightContent").attr("src",dfpage);
		
		var wH=$(window).height();
		$("#rightContent").css({"height":wH-80,"border":"none"});
		
		$("li",$(".sidebar ul")).removeClass("active");
});