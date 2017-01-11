<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>学生信息管理系统</title>
<!-- thirdparty css -->
<link rel="stylesheet" href="thirdparty/bootstrap-3.3.7/css/bootstrap.min.css">
<!-- personal css -->
<link rel="stylesheet" href="css/index.css">
<!-- thirdparty js -->
<script src="thirdparty/jquery-3.1.1/jquery-3.1.1.min.js"></script>
<script src="thirdparty/jquery-3.1.1/jquery.cookie.min.js"></script>
<script src="thirdparty/jquery-3.1.1/jquery.nicescroll.min.js"></script>
<script src="thirdparty/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<!-- personal js -->
<script src="js/common/mainMenuBar1.js"></script>
<script src="js/utils/accordionMenu.js"></script>
</head>
<body>
    <div id="indexMask1" style="height:100%;opacity:0.2;position:fixed;left:0px;top:0px;z-index:9999;background-color:black;display:none"></div>
    <div id="indexMask2" style="height:100%;opacity:0.2;position:fixed;left:0px;top:0px;z-index:9999;background-color:black;display:none"></div>
    <div class="navbar navbar-default navbar-fixed-top">
		<div class="container navpanel">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<div class="navbar-brand navbarLogo">
					<div class="menuL" id="slideToggle">
						<i class="glyphicon glyphicon-fullscreen"></i>
					</div>
				</div>
			</div>
			<div class ="navbar-collapse collapse">
				<ul class="nav navbar-nav btnExit">
					<li>
						<img src="images/header.png" style="height: 40px;"></img>
					</li>
					<li>
						<p>${sessionScope.cmsUser.userName}</p>
					</li>
					<li>
						<a class="login-out" href="/cms/loginOut" title="退出"></a>
					</li>
					<li>
						<a class="exchange-passwd" href="#" title="修改密码"></a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="wrapper row-offcanvas wrapper-top wrapperIndex top-60">
		<aside class="left-side sidebar-off-canvas">
			<section class="sidebar">
				<ul class="sidebar-menu nav" style="overflow:hidden;outline:none;" tabindex="0">
					<c:forEach items="${sessionScope.menuList}" var="menu">
  						 <li>
  						 	<a data-path="${menu.path}">${menu.menuName}</a>
  						 	<c:if test="${!(menu.childSize eq 0)}">
   								<ul>
   									<c:forEach items="${menu.childMenuList}" var="childMenu">
   										<li><a data-path="${childMenu.path}">${childMenu.menuName}</a></li>
   									</c:forEach>
   								</ul>
							</c:if>
  						 </li>
					</c:forEach>
				</ul>
			</section>
		</aside>
		<aside id="rightside" class="right-side rightPy ct on" style="position:fixed;">
			<iframe id="rightContent" width="100%" height="100%">
			</iframe>
		</aside>
	</div>
	<!-- 修改密码弹出框-->
	<div class="modal fade" id="expasswdAlert" tabindex="-1" role="dialog" aria-labelledby="expasswdAlertLable" aria-hidden="true">
	    <div class="modal-dialog" style="width:370px;">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="expasswdAlertLable">修改密码</h4>
	            </div>
	            <div class="modal-body">
	            	<div class="row" id="exchange-overview" style="display: block;">
	            		<div class="col-xs-12 col-sm-12 col-md-12">
	            			<form id="exchange-form" role="form" method="post">
	            				<div class="form-group">
	            					<div id="exchange-msg" class="col-xs-12 col-sm-12 col-md-12 alert alert-warning">警告：</div>
	            				</div>
	            				<div class="form-group">
	            					<input type="password" name="old-password" id="old-password" class="form-control input-lg" placeholder="请输入旧密码">
	            					
	            				</div>
	            				<div class="form-group">
	            					<input type="password" name="password-exchange" id="password-exchange" class="form-control input-lg" placeholder="请输入密码">
	            					<span id="strength" class="low">低</span>
	            				</div>
	            				<div class="form-group">
	            					<input type="password" name="confirm-password" id="confirm-password" class="form-control input-lg" placeholder="确认密码">
	            					
	            				</div>
	            			</form>
	            		</div>
	            	</div>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" id="exSubmitBtn">确认</button>
	                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	            </div>
	        </div>
	    </div>
	</div>
	<script type="text/javascript">
		$(function() {
			if($.cookie("showLeftBar") !=="hide" && localStorage.showLeftBar !== "hide")
			{
				$("#rightside").css("width",$(window).width()-$(".left-side").width());
			}
			else
			{
				$("#rightside").css("width",$(window).width());
			}
			$("#indexMask1").css("width",$(".left-side").width()+1);
			$("#indexMask2").css({"height":$(".navbar-fixed-top").height()+$(".content-header").height()+9,"left":$(".left-side").width()});
			$(".exchange-passwd").on("click",function()
			{
				$("#expasswdAlert").modal("show");
			})
			// 验证密码强度
			$("#password-exchange").keyup(function() {
				var password = $("#password-exchange").val();
		
				if (password.length >= 6) {
					$.ajax({
						type: $("#exchange-overview").attr("method"),
						url: '',
						data: "password=" + password,
				
						success: function(res) {
							$("#strength").css('display', 'block');
							if (res >= 0 && res <= 2) {
								$("#strength").attr('class', 'low');
								$("#strength").html("低：尝试用大小写混合，以及特殊字符");
								return false;
							} else if (res >= 3 && res <= 5) {
								$("#strength").attr('class', 'middle');
								$("#strength").html("中：尝试用大小写混合，以及特殊字符");
								return false;
							} else {
								$("#strength").attr('class', 'high');
								$("#strength").html("高：请牢记您的密码");
								return false;
							}
						}
					});
				} else {
					$("#strength").attr('class', 'red');
					$("#strength").html("密码长度不能少于6位");
				}
			});

			// 提交表单
			$("#exSubmitBtn").click(function() {
				var oldpassword = $("#old-password").val();
				var password = $("#password-exchange").val();
				var confirmPassword = $("#confirm-password").val();
				if (!password && !oldpassword) {
					$("#exchange-msg").css('display', 'block');
					$("#exchange-msg").css('visibility', 'visible');
					$("#exchange-msg").html("密码不能为空");
					return false;
				}
		
				if(password.length < 6) {
					$("#exchange-msg").css('display', 'block');
					$("#exchange-msg").css('visibility', 'visible');
					$("#exchange-msg").html("密码长度不能少于6位");
					return false;
				}
		
				if (password != confirmPassword) {
					$("#exchange-msg").css('display', 'block');
					$("#exchange-msg").css('visibility', 'visible');
					$("#exchange-msg").html("密码不一致,请确认");
					return false;
				}
				var obj = {
					"oldPassWord":oldpassword,
					"newPassWord":password
				}
				$.ajax({
					url: '/cms/editUser',
					type:"POST",
					data: JSON.stringify(obj),
					dataType:"json",
					contentType: "application/json",
					success: function(data, textStatus)
					{
						if (data.rtnCode == "0")
						{
							window.location="/cms/loginOut";
							$("#exchange-msg").css('display', 'none');
							$("#exchange-msg").css('visibility', 'hidden');
						} 
						else 
						{
							$("#exchange-msg").css('display', 'block');
							$("#exchange-msg").css('visibility', 'visible');
							$("#exchange-msg").html(data.errMsg);
						}
					}
				});
			});

		});
	</script>
</body>
</html>