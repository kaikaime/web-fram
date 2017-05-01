<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/function-manage.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-3.0.0.min.js"></script>
<script type="text/javascript">
	var baseUrl  ="${pageContext.request.contextPath }/product.do?method=findProductCategoryInfo&";
	$(function(){
			var categoryUrl =baseUrl+"category=parentCategory";
			$.getJSON(categoryUrl,function(data){
				$(data).each(function(i,e){
					$(".parentNick").append("<option value"+e.shopCategoryNick+">"+e.shopCategoryNick+"</option>");
					//默认显示第一类商品
					if(i==0){
						$(e.shopChildCategoryPojo).each(function(i,e){
							$(".childId").append("<option value="+e.shopChildCategoryNick+">"+e.shopChildCategoryNick+"</option>");
						});
					} 
				});
			}); 
			$(".parentNick").change(function(){
				var childCategoryUrl=baseUrl+"category=childCategory&categoryNick="+$(this).val();//$(this).val()
				$.getJSON(childCategoryUrl,function(data){
					if(data!=null){}
				});
			});
		});
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${pageContext.request.contextPath }/images/logo.gif" /></div>
	<div class="help"><a href="${pageContext.request.contextPath }/index.html">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.html">首页</a></li>
			<li><a href="user.html">用户</a></li>
			<li class="current"><a href="product.html">商品</a></li>
			<li><a href="order.html">订单</a></li>
			<li><a href="guestbook.html">留言</a></li>
			<li><a href="news.html">新闻</a></li>
		</ul>
	</div>
</div>
<jsp:include page="/resource/headtime.jsp"/>
<div id="position" class="wrap">
	您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<jsp:include page="/manage/left-content.jsp"></jsp:include>
		</div>
	</div>
	<div class="main">
		<h2>修改商品</h2>
		<div class="manage">
			<form action="${pageContext.request.contextPath }/product.do?method=updateByIdProduct" method="post" enctype="multipart/form-data">
				<table class="form">
				<tr>
					<td colspan="2">
						<input  type="hidden" value="${pojo.productId}" name="productId"/>
					</td>
				</tr>
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" class="text" name="productName" value="${pojo.productName}" /></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="parentId" class="parentNick">
							</select>
							<select name="childId" class="childId">
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">商品图片：</td>
						<td><input type="file" class="text" name="photo" /></td>
					</tr>
					<tr>
						<td class="field">商品价格：</td>
						<td><input type="text" class="text tiny" name="productPrice" value="${pojo.productPrice}" /> 元</td>
					</tr>
					<tr>
						<td class="field">品牌：</td>
						<td><input type="text" class="text" name="productPingpaiName" value="${pojo.productPingpaiName}"/></td>
					</tr>
					<tr>
						<td class="field">库存：</td>
						<td><input type="text" class="text tiny" name="productRepo" value="${pojo.productRepo}"/></td>
					</tr>
					<tr>
						<td class="field">条码号：</td>
						<td><input type="text" class="text" name="tiaoxingma" value="${pojo.tiaoxingma}"/></td>
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
	Copyright &copy; 易买网 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>