<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/function-manage.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-3.0.0.min.js"></script>
<script type="text/javascript">
	$(function(){
			$("form").submit(function(){
				if($(".text").val()==""){
					alert("请输入分类名称!");
					return false;
				}
				return true;
			});
	});

</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${pageContext.request.contextPath }/images/logo.gif" /></div>
	<div class="help"><a href="${pageContext.request.contextPath }/index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li class="current"><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li><a href="news.jsp">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	 <jsp:include page="/resource/headtime.jsp"/>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<jsp:include page="/manage/left-content.jsp"></jsp:include>
		</div>
	</div>
	<div class="main">
		<h2>添加分类</h2>
		<div class="manage">
			<form action="${pageContext.request.contextPath }/category.do?method=addShopCategory" method="post" name="form1">
				<table class="form">
					<tr>
						<td class="field">父分类：</td>
						<td>
							<select name="parentId">
								<option value="电器">电器</option>
								<option value="衣服">衣服</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">分类名称：</td>
						<td><input type="text" class="text" name="className" value="电脑" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="添加" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 易买网 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
