<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/function-manage.js"></script>
</head>
<body>
	<div id="header" class="wrap">
			<div id="logo"><img src="${pageContext.request.contextPath }/images/logo.gif" /></div>
			<div class="help"><a href="${pageContext.request.contextPath }/index.jsp">返回前台页面</a></div>
			<div class="navbar">
				<ul class="clearfix">
					<li><a href="index.jsp">首页</a></li>
					<li class="current"><a href="${pageContext.request.contextPath }/manage/user.jsp">用户</a></li>
					<li><a href="${pageContext.request.contextPath }/manage/product.jsp">商品</a></li>
					<li><a href="${pageContext.request.contextPath }/manage/order.jsp">订单</a></li>
					<li><a href="${pageContext.request.contextPath }/manage/guestbook.jsp">留言</a></li>
					<li><a href="${pageContext.request.contextPath }/manage/news.jsp">新闻</a></li>
				</ul>
			</div>
		</div>
		<div id="childNav">
			<div class="welcome wrap">
				管理员pillys您好，今天是2018-12-21，欢迎回到管理后台。
			</div>
		</div>
		<div id="position" class="wrap">
			您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
		</div>
	</body>
</html>