<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-3.0.0.min.js" ></script>
<style>
	.check{margin-left: 10px;}
	.go-shop{
		cursor: pointer;
		width: 100px;
		height: 30px;
		border-bottom-right-radius: 3px;
		border-bottom-left-radius: 3px;
		border-top-left-radius: 3px;
		border-top-right-radius: 3px;
		background-color: #FC7E31;
		color: #FFFFFF;
		text-align: center;
		line-height: 30px;
		margin-left: 850px;
		margin-top: 20px;
		font-size:15px;
		font-family: "楷体";
		border: 0px solid #ffffff;
	}
	.left{
		margin-left: 100px;
		text-align: center;
	}
</style>
<script>
	$(function(){
		$(".all-check").change(function(){
			$(":checkbox").attr("checked",this.checked);
		})
		$(".go-shop").click(function(){
			var isChecked=false;
			var index=-1;
			$(".check").each(function(i,e){
				if($(e).is(":checked")){
					isChecked = true;
					index=i;
				}
			})
			if(isChecked!=true){
				alert("你还没有选择订单!");
				return false;
			}
		})
		
	});
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="#" class="shopping">购物车</a><a href="login.html">登录</a><a href="register.html">注册</a><a href="guestbook.html">留言</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="#">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="${pageContext.request.contextPath }/order.do?method=findOrder" method="post">
			<table>
				<tr>
					<th><input type="checkbox" name="check" class="all-check"/>&nbsp;全&nbsp;选</th>
					<th>商品图</th>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${shopCar}" var="item">
					<tr id="product_id_1">
					<td>
						<input type="checkbox" name="check" class="check"/>
						<input type="hidden" name="productId" value="${item.key.productId}" class="pro_id"/>
					</td>
					<td class="thumb"><img class="left" src="${pageContext.request.contextPath }/images/product/${item.key.imgUrl}" width="30px" height="30px"/></td>
					<td class="thumb"><a class="left" href="product-view.jsp">${item.key.productName}</a></td>
					<td class="price" id="price_id_1">
						<span>￥${item.key.productPrice*1*item.value}</span>
					</td>
					<td class="number">
						${item.value}
						<input type="hidden" value="${item.value}" name="number"/>
					</td>
					<td class="delete"><a href="${pageContext.request.contextPath }/goShop.do?method=deleteShopCarProduct&productId=${item.key.productId}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="结&nbsp;算" class="go-shop" />
			<div class="button"></div>
		</form>
	</div>
	
</div>
<div id="footer">
	Copyright &copy; 易买网 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>