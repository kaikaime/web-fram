<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD Xhtml 1.0 Transitional//EN" "http://www.w3.org/TR/xjsp1/DTD/xjsp1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/function-manage.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-3.0.0.min.js"></script>
<script type="text/javascript">
	/* $(function(){
		setInterval(function(){
		var url="${pageContext.request.contextPath }/findHeadInfo.do?method=findHeadInfo&&info=headinfor";
			$.getJSON(url,function(data){
				$(".welcome").html("管理员pillys您好，欢迎回到管理后台。&nbsp;&nbsp;時間：&nbsp;"+data.time);
			});
		}, 1000);
	}); */
	
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${pageContext.request.contextPath }/images/logo.gif" /></div>
	<div class="help"><a href="${pageContext.request.contextPath }/index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li class="current"><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li><a href="news.jsp">新闻</a></li>
		</ul>
	</div>
</div>

<jsp:include page="/resource/headtime.jsp"/>
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
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>邮箱</th>
					<th>手机</th>
					<!-- <th>操作</th> -->
				</tr>
				
			 	<c:forEach items="${all.list}" var="item">
					<tr>
						<td class="first w4 c">${item.userId }</td>
						<td class="w1 c">${item.userName }</td>
						<c:if test="${item.userSex==1}">
							<td class="w2 c">男</td>
						</c:if>
						<c:if test="${item.userSex==0}">
							<td class="w2 c">女</td>
						</c:if>
						<td>${item.userEmail }</td>
						<td class="w4 c">${item.userTel }</td>
						<%-- <td class="w1 c">
							<a href="${pageContext.request.contextPath}/userma.do?method=findByIdUser&userId=${item.userId}">修改</a>
						 	<a href="${pageContext.request.contextPath}/userma.do?method=deleteByIdUser&userId=${item.userId}">删除</a>
						 </td> --%>
					</tr>
				</c:forEach> 
			</table>
			<div class="pager">
				<ul class="clearfix">
					<li><a href="${pageContext.request.contextPath}/userma.do?method=findAll&pageId=${all.currentPage-1<1?1:all.currentPage-1}">上一页</a></li>
					<c:if test="${all.currentPage<=6}">
						<c:forEach begin="1" end="${all.totalPage<10?all.totalPage:10}" var="i">
							<c:if test="${i==all.currentPage}">
								<li class="current">${i}</li>
							</c:if>
							<c:if test="${i!=all.currentPage}">
								<li><a href="${pageContext.request.contextPath}/userma.do?method=findAll&pageId=${i}">${i}</a></li>
							</c:if>
						</c:forEach>
					</c:if>
					<c:if test="${all.currentPage>=7 }">
						<c:forEach begin="${all.currentPage-5}" end="${all.totalPage>all.currentPage+4?all.currentPage+4:all.totalPage}" var="i">
							<c:if test="${i==all.currentPage}">
								<li class="current">${i}</li>
							</c:if>
							<c:if test="${i!=all.currentPage}">
								<li><a href="${pageContext.request.contextPath}/userma.do?method=findAll&pageId=${i}">${i}</a></li>
							</c:if>
						</c:forEach>
					</c:if>
					<li><a href="${pageContext.request.contextPath}/userma.do?method=findAll&pageId=${all.currentPage+1>all.totalPage?all.totalPage:all.currentPage+1}">下一页</a></li>
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