<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE jsp PUBLIC "-//W3C//DTD Xjsp 1.0 Transitional//EN" "http://www.w3.org/TR/xjsp1/DTD/xjsp1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-3.0.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".very_class").click(function(){
			var urls = "${pageContext.request.contextPath}/verycode.do?veryCode=veryCode&math="+Math.random()+"";
			$(this).attr("src",urls);
		});
		$("form").submit(function(){
			 if($(".text").eq(0).val()!=""
			 &&$(".text").eq(1).val()!=""){
				return true;
			} 
			return false;
		});
	});
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="javascript:void(0)" class="shopping">购物车</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a><a href="guestbook.jsp">留言</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="javascript:void(0)">首页</a></li>
			<li><a href="javascript:void(0)">图书</a></li>
			<li><a href="javascript:void(0)">百货</a></li>
			<li><a href="javascript:void(0)">品牌</a></li>
			<li><a href="javascript:void(0)">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="javascript:void(0)">音乐</a></li>
			<li><a href="javascript:void(0)">影视</a></li>
			<li><a href="javascript:void(0)">少儿</a></li>
			<li><a href="javascript:void(0)">动漫</a></li>
			<li><a href="javascript:void(0)">小说</a></li>
			<li><a href="javascript:void(0)">外语</a></li>
			<li><a href="javascript:void(0)">数码相机</a></li>
			<li><a href="javascript:void(0)">笔记本</a></li>
			<li><a href="javascript:void(0)">羽绒服</a></li>
			<li><a href="javascript:void(0)">秋冬靴</a></li>
			<li><a href="javascript:void(0)">运动鞋</a></li>
			<li><a href="javascript:void(0)">美容护肤</a></li>
			<li><a href="javascript:void(0)">家纺用品</a></li>
			<li><a href="javascript:void(0)">婴幼奶粉</a></li>
			<li><a href="javascript:void(0)">饰品</a></li>
			<li class="last"><a href="javascript:void(0)">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎回到易买网</h1>
			<form id="loginForm" method="post" action="${pageContext.request.contextPath }/login.do?method=login" onsubmit="return checkForm(this)">
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input class="text" type="text" name="userName" onfocus="FocusItem(this)" onblur="CheckItem(this);" placeholder="${msg}"/><span></span></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" type="password" id="passWord" name="passWord" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">验证码：</td>
						<td><input id="verycodeId" class="text verycode" type="text" name="veryCode" onfocus="FocusItem(this)" onblur="CheckItem(this);" placeholder="${msg}"/><img id="veryCode" class="very_class" src="${pageContext.request.contextPath}/verycode.do?veryCode=veryCode" /><span></span></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" value="立即登录" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy;易买网 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>