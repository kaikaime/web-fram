<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
			<li><a href="user.jsp">用户</a></li>
			<li class="current"><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li><a href="news.jsp">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<jsp:include page="/resource/headtime.jsp" />
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
		<h2>分类管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>分类名称</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${all.list }" var="item">
					<tr style="height: 40px;text-align: center;">
						<td class="first w4 c">${item.shopCategoryId}</td>
						<td>${item.shopCategoryNick}</td>
						<td class="w1 c"><a href="${pageContext.request.contextPath}/category.do?method=deleteShopParentCategory&productParentCateChilCategoryId=${item.shopCategoryId}">删除</a></td></td>
					</tr>
					<c:forEach items="${item.shopChildCategoryPojo}" var="items">
						<tr style="font-size: 12px;text-align: left;">
							<td class="first w4 c" style="text-align: right;">${items.shopChildCategoryId}</td>
							<td class="childClass">${items.shopChildCategoryNick}</td>
							<td class="w1 c">
								<a href="${pageContext.request.contextPath}/category.do?method=findByIdShopCategory&productCateChilCategoryId=${items.shopChildCategoryId}">修改</a>
							 	<a href="${pageContext.request.contextPath}/category.do?method=deleteShopChildCategory&productCateChilCategoryId=${items.shopChildCategoryId}">删除</a></td>
						</tr>
					</c:forEach>
				</c:forEach>
			</table>
			<div class="pager">
				<ul class="clearfix">
					<li><a href="${pageContext.request.contextPath}/category.do?method=findAll&pageId=${all.currentPage-1<1?1:all.currentPage-1}">上一页</a></li>
					<c:if test="${all.currentPage<=6}">
						<c:forEach begin="1" end="${all.totalPage<10?all.totalPage:10}" var="i">
							<c:if test="${i==all.currentPage}">
								<li class="current">${i}</li>
							</c:if>
							<c:if test="${i!=all.currentPage}">
								<li><a href="${pageContext.request.contextPath}/category.do?method=findAll&pageId=${i}">${i}</a></li>
							</c:if>
						</c:forEach>
					</c:if>
					<c:if test="${all.currentPage>=7}">
						<c:forEach begin="${all.currentPage-5}" end="${all.totalPage>all.currentPage+4?all.currentPage+4:all.totalPage}" var="i">
							<c:if test="${i==all.currentPage}">
								<li class="current">${i}</li>
							</c:if>
							<c:if test="${i!=all.currentPage}">
								<li><a href="${pageContext.request.contextPath}/category.do?method=findAll&pageId=${i}">${i}</a></li>
							</c:if>
						</c:forEach>
					</c:if>
					<li><a href="${pageContext.request.contextPath}/category.do?method=findAll&pageId=${all.currentPage+1>all.totalPage?all.totalPage:all.currentPage+1}">下一页</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 易买网 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>