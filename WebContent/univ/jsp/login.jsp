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
<link rel="stylesheet" href="<%=request.getContextPath() %>/univ/thirdparty/bootstrap-3.3.7/css/bootstrap.min.css">
<!-- personal css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/univ/css/login.css">
<!-- thirdparty js -->
<script src="<%=request.getContextPath() %>/univ/thirdparty/jquery-3.1.1/jquery-3.1.1.min.js"></script>
<script src="<%=request.getContextPath() %>/univ/thirdparty/jquery-3.1.1/jquery.cookie.min.js"></script>
<script src="<%=request.getContextPath() %>/univ/thirdparty/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<div class="navbar-brand navbar-logo">
				</div>
			</div>
			<div class ="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right navleader">
					<li>
						<a><i class="glyphicon glyphicon-heart"></i>加入收藏夹</a>
					</li>
					<li>
						<a><i class="glyphicon glyphicon-share-alt"></i>生产快捷方式</a>
					</li>
				</ul>
				<p class="nav navbar-nav navbar-left title">智慧学工管理系统</p>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="backLogo"></div>
			<div class="loginPanel"> 
				<div class="loginTilte">
					<p>智慧学工用户登录</p>
				</div>
				<form class="form-signin" role="form" action="/cms/loginCheck" method="post">
				<c:choose>
			       <c:when test="${!empty errMsg}">
		               <div class="alert-info">${errMsg}</div>
			       </c:when>
			       <c:otherwise>
			       	<div class="alert-info"></div>
			       </c:otherwise>
				</c:choose>
				<input type="text" name="userName" class="form-control" placeholder="用户名" required="required"/>
				<input type="passWord" name="passWord" class="form-control" placeholder="密码" required="required"/>
				<div class="checkbox">
		          <label>
		            <input type="checkbox" value="remember-me">记住用户名
		          </label>
		          <a href="#" style="float:right">忘记密码？</a>
	        	</div>
	        	<button class="btn btn-lg btn-block loginBtn" type="submit">登录</button>
			</form>
			</div>
			<div class="clr">
		</div>
	</div>
	</div>
</body>
</html>