<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/function-manage.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/function-date.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-3.0.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		onloadDate();
		$("form").submit(function(){
			 if($("input[name='userName']").val()==""){
				alert("请输入用户名!");
				return false;
			}else if($("input[name='name']").val()==""){
				alert("请输入姓名!");
				return false;
			}else if($("input[name='passWord']").val()==""){
				alert("请输入密码!");
				return false;
			}else if($("input[name='sex']").val()==""){
				alert("请输入性别!");
				return false;
			}else if($("input[name='mobile']").val()==""){
				alert("请输入联系方式!");
				return false;
			}else if($("input[name='userEmail']").val()==""){
				alert("请输入送货地址!");
				return false;
			}else if($("input[name='photo']").val()==""){
				alert("请输入上传头像!");
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
			<li class="current"><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
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
		<h2>修改用户</h2>
		<div class="manage">
			<form name=form1 action="${pageContext.request.contextPath }/userma.do?method=updateByIdUser" method="post" enctype="multipart/form-data">
				<table class="form">
					<tr><td colspan="2"><input type="hidden" value="${userPojo.userId}" name="userId"/></td></tr>
					<tr>
						<td class="field">用户名：</td>
						<td><input type="text" class="text" name="userName" value="${userPojo.userName}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">姓名：</td>
						<td><input type="text" class="text" name="name" value="${userPojo.name}" /></td>
					</tr>
					<tr>
						<td class="field">密码：</td>
						<td><input type="text" class="text" name="passWord" value="${userPojo.userPass}" /></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td>
							<c:if test="${userPojo.userSex==1}">
								<input type="radio" name="sex" value="1" checked="checked" />&nbsp;男 &nbsp;&nbsp;<input type="radio" name="sex" value="0" />&nbsp;女 
							</c:if>
							<c:if test="${userPojo.userSex==0}">
								<input type="radio" name="sex" value="1" />&nbsp;男 &nbsp;&nbsp;<input type="radio" name="sex" value="0" checked="checked" />&nbsp;女 
							</c:if>
						</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>
						 	<select name="birthyear" onchange="YYYYMM(this.value)">
								<option value=""></option> 
							</select>年
							<select name="birthmonth" onchange="MMDD(this.value)">
								<option value=""></option> 
							</select>月
							<select name="birthday">
								<option value=""></option>  
							</select>日
						</td>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="mobile" value="${userPojo.userTel}" /></td>
					</tr>
					<tr>
						<td class="field">邮箱：</td>
						<td><input type="text" class="text" name="userEmail" value="${userPojo.userEmail}" /></td>
					</tr>
					<tr>
						<td class="field">头像：</td>
						<td><input type="file" class="text" name="photo" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
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