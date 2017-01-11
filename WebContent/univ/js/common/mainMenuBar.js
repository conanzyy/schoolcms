var list=[];
var icons=[];
var iconsClassArr=[];
var nameValuePair={};
var dfpage;
var Formatter={
		format:function(tpl){
			var reg=new RegExp(/\{(\d+)\}/g);
			var ret=tpl;
			while((rs=reg.exec(tpl)) !=null){
				ret=ret.replace(rs[0].toString(),arguments[parseInt(rs[1],10)+1]);
			}
			return ret;
		}
};
var template='<li id="menu_{0}"><div><i class="{1}"></i>{2}</div></li>';
$(function(){
	
	for(var k in icons){
		iconsClassArr.push("glyphicon glyphicon-"+icons[k]);
	}
	var user = {"userName":"admin","passWord":"admin"};
	//查询菜单
	$.ajax({
		url : "/cms/getMenu",
		dataType : "json",
		type : "POST",
		data: JSON.stringify(user),
		contentType : "application/json;charset=utf-8",
		async: false,
		success : function(data) 
		{
			drawLeftMenu(data);
		},
		error : function() {
		}
	});
	list.push({path:"homepage",title:"首页",style:"glyphicon glyphicon-send",sort:0});
	list.push({path:"personal",title:"个人信息",style:"glyphicon glyphicon-folder-close",sort:2});
	list.push({path:"study",title:"学习成绩",style:"glyphicon glyphicon-inbox",sort:2});
	list.push({path:"employ",title:"就业信息",style:"glyphicon glyphicon-pencil",sort:2});
	list.push({path:"doctor",title:"医保信息",style:"glyphicon glyphicon-send",sort:2});
	list.push({path:"heart",title:"心理健康信息",style:"glyphicon glyphicon-lock",sort:2});
	list.push({path:"heart",title:"心理健康信息",style:"glyphicon glyphicon-lock",sort:2});
	list.push({path:"heart",title:"心理健康信息",style:"glyphicon glyphicon-lock",sort:2});
	list.push({path:"heart",title:"心理健康信息",style:"glyphicon glyphicon-lock",sort:2});
	list.push({path:"heart",title:"心理健康信息",style:"glyphicon glyphicon-lock",sort:2});
	list.push({path:"heart",title:"心理健康信息",style:"glyphicon glyphicon-lock",sort:2});
	list.push({path:"heart",title:"心理健康信息",style:"glyphicon glyphicon-lock",sort:2});
	list.push({path:"heart",title:"心理健康信息",style:"glyphicon glyphicon-lock",sort:2});
	
	drawLeftMenu(null);
	

	//激活状态点击事件
	$(".sidebar .sidebar-menu>li ul li").on("click",function(){
		$(".sidebar-menu li ul li").removeClass("active");
		$(this).addClass("active");
	})
	//全屏模式
	$("#slideToggle").on("click",function(){
		$.cookie("showLeftBar");
		if($(".content-header").hasClass("content-headerLs"))
		{
			$("#rightside").css("width",$(window).width());
			$(".content-header").removeClass("content-headerLs");
			$("#rightside").addClass("right-sideLs");
			$.cookie("showLeftBar","hide");
			localStorage.showLeftBar="hide";
		}
		else
		{
			$("#rightside").css("width",$(window).width()-$(".left-side").width());
			$(".content-header").addClass("content-headerLs");
			$("#rightside").removeClass("right-sideLs");
			$.cookie("showLeftBar","show");
			localStorage.showLeftBar="show";
		}
		$(".left-side").toggle();
	})
	
	if($.cookie("showLeftBar") =="hide" || localStorage.showLeftBar == "hide")
	{
		$(".content-header").removeClass("content-headerLs");
		$("#rightside").addClass("right-sideLs");
		$(".left-side").hide();
		$("#rightside").css("width",$(window).width());
	}
	//滚动条样式
	$(".left-side").niceScroll({cursorcolor:"#bcbcbc",cursorborder:"#bcbcbc",mousescrollstep:"60",scrollspeed:"80"});
	$("body").niceScroll({cursorcolor:"#bcbcbc",cursorborder:"#bcbcbc",mousescrollstep:"60",scrollspeed:"80"});
	
	var lastVisitNew=$.cookie("lastVisitNew");
	if(!lastVisitNew && window.localStorage)
		lastVisitNew=localStorage.localStorage;
	var dfpage="homepage";
	if(lastVisitNew&&lastVisitNew.length>0)
		dfpage=lastVisitNew;
	$("#rightContent").attr("src",dfpage);
	
	var wH=$(window).height();
	$("#rightContent").css({"height":wH-90,"border":"none"});
	
	$("li",$(".sidebar ul")).removeClass("active");
    $("#menu_"+dfpage).addClass("active");
    
    if(nameValuePair[dfpage]=="首页")
    {
    	$("#titleName").prev("span").text("");
    	$("#titleName").text("");
    }
    else
    {
    	$("#titleName").prev("span").text(">");
    	$("#titleName").text(nameValuePair[dfpage]);
    }
})

function ifnull(a,b)
{
	return a == null||a == ""?b:a;
}

function drawLeftMenu(data)
{
	$.each(data,function(index,value)
	{
		var menuObj={
			path:value.path,
		    title:value.name,
		    style:"glyphicon glyphicon-lock",
		    sort:value.sort
		}
		list.push(menuObj);
	})
	
	var barContainer=$(".sidebar ul");
	barContainer.empty();
	barContainer.append('<li class="nav-header"><i class="glyphicon glyphicon-home"></i>首页</li><li><ul></ul></li>');
	barContainer.append('<li class="nav-header"><i class="glyphicon glyphicon-bell"></i>公告通知管理<span style="float:right" class="glyphicon glyphicon-triangle-left"></span></li><li><ul></ul></li>');
	barContainer.append('<li class="nav-header"><i class="glyphicon glyphicon-book"></i>学生基础信息<span style="float:right" class="glyphicon glyphicon-triangle-left"></span></li><li><ul></ul></li>');
	barContainer.append('<li class="nav-header"><i class="glyphicon glyphicon-asterisk"></i>事务管理<span style="float:right" class="glyphicon glyphicon-triangle-left"></span></li><li><ul></ul></li>');
	barContainer.append('<li class="nav-header"><i class="glyphicon glyphicon-envelope"></i>活动管理<span style="float:right" class="glyphicon glyphicon-triangle-left"></span></li><li><ul></ul></li>');
	barContainer.append('<li class="nav-header"><i class="glyphicon glyphicon-phone"></i>预约咨询<span style="float:right" class="glyphicon glyphicon-triangle-left"></span></li><li><ul></ul></li>');
	barContainer.append('<li class="nav-header"><i class="glyphicon glyphicon-list-alt"></i>约谈管理<span style="float:right" class="glyphicon glyphicon-triangle-left"></span></li><li><ul></ul></li>');
	barContainer.append('<li class="nav-header"><i class="glyphicon glyphicon-list"></i>学生成绩表<span style="float:right" class="glyphicon glyphicon-triangle-left"></span></li><li><ul></ul></li>');
	barContainer.append('<li class="nav-header"><i class="glyphicon glyphicon-paperclip"></i>数据查询统计<span style="float:right" class="glyphicon glyphicon-triangle-left"></span></li><li><ul></ul></li>');
	
	$(".nav-header").on("click",function(){
		var titleText=$(this).text();
		if(titleText.trim() == "首页")
		{
			$("#rightContent").attr("src","homepage.jsp");
			$("#titleName").text("").prev("span").text("");
			$(".sidebar-menu >li ul li").removeClass("active");
			$(this).addClass("active");
			$.cookie("homepageLi","true");
			return;
		}
		$.cookie("homepageLi","false");
		$(this).next("li").find("ul").slideToggle();
		//保存折叠状态到浏览器缓存
		var curIndex=$(this).closest("ul").first().find(".nav-header").index($(this));
		var cursts=$.cookie("tabVisible"+curIndex);
		if(cursts == null || cursts == "undefine")
		{
			cursts ="true";
		}
		else
		{
			cursts=(cursts=="true"?"false":"true");
		}
		
		$.cookie("tabVisible"+curIndex,cursts);
		
		if($("span",$(this)).hasClass("glyphicon glyphicon-triangle-left"))
		{
			$("span",$(this)).removeClass("glyphicon glyphicon-triangle-left").addClass("glyphicon glyphicon-triangle-bottom");
		}
		else
		{
			$("span",$(this)).removeClass("glyphicon glyphicon-triangle-bottom").addClass("glyphicon glyphicon-triangle-left");
		}
	})
	
	for(var v in list)
	{
		nameValuePair=$.extend(nameValuePair,$.parseJSON("{\""+list[v].path+"\":\"" +list[v].title+"\"}"));
		$(Formatter.format(template,list[v].path,ifnull(list[v].style,iconsClassArr[v]),list[v].title))
		.prependTo($(barContainer.find(".nav-header")[list[v].sort]).next("li").find("ul")).on("click",function(){
			$.cookie("homepageLi","false");
			var src=this.id.split("_")[1];
			$("#rightContent").attr("src",src);
			//操作保存到浏览器缓存
			$.cookie("lastVisitNew",src,{expire:3,path:"/"});
			//保存到本地缓存
			if(window.localStorage)
			{
				localStorage.localStorage=src;
			}
			if(nameValuePair[src] =="首页")
			{
				$("#titleName").text("");
			}
			else
			{
				$("#titleName").text(nameValuePair[src]);
			}
		})
	}
	
	$("li",$(".nav-header").next("li")).on("click",function(){
		$("#titleName").prev("span").text(">");
	})
	
	for(var i=0;i<9;i++){
		var ck=$.cookie("tabVisible"+i);
		if(ck ==null || ck=="false"){
			$(".nav-header").eq(i).next("li").find("ul").hide();
		}
	}
	
	if($.cookie("homepageLi")=="true" ||$.cookie("homepageLi")==null )
    {
    	$(".nav-header").eq(0).click();
    }
	
	//hide main menu if no children
	$("li.nav-header").each(function(){
		var urls=$(this).next("li").find("ul").children("li");
		var show =false;
		$(urls).each(function(){
			if(typeof($(this).attr("style")) == "undefined")
			{
				show = true;
			}
		});
		if(false === show)
		{
			$(this).css("display","none");
		}
	});
	
}

