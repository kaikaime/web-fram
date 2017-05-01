<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE jsp PUBLIC "-//W3C//DTD Xjsp 1.0 Transitional//EN" "http://www.w3.org/TR/xjsp1/DTD/xjsp1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-3.0.0.min.js"></script>
		<style>
			.div-box{
				border: 1px solid aliceblue;
				width: 300px;
				height: 100px;
			}
			.div-box .div-number{
				border: 1px solid aliceblue;
				width: 300px;
				height: 60px;
				background-color: cornsilk;
			}
			.div-box .div-btn{
				border: 1px solid aliceblue;
				width: 300px;
				height: 40px;
				background-color:floralwhite;
			}
			.div-box .div-btn .div-go,.div-goshopCar{
				cursor: pointer;
				color: #FFFFFF;
				line-height: 40px;
				font-family: "楷体";
				text-align: center;
				float: left;
				width:100px;
				height: 40px;
				border-bottom-left-radius: 3px;
				border-bottom-right-radius: 3px;
				border-top-left-radius: 3px;
				border-top-right-radius: 3px;
			}
			.div-box .div-btn .div-go{
				margin-left: 20px;
				background-color:#FC7E31;
				
			}
			.div-box .div-btn .div-goshopCar{
				margin-left: 30px;
				background-color:#FC7E31;
			}
			.div-box .div-number .span-number{
				font-size: 15px;
				font-family: "楷体";
				line-height: 60px;
				margin-left: 20px;
				float: left;
			}
			.div-box .div-number .div-box-jisuan{
				margin-top: 10px;
				margin-left: 50px;
				float: left;
				width: 128px;
				height: 40px;
				border: 1px solid aliceblue;
			}
			.div-box .div-number .div-box-jisuan .div-input-number{
				width: 50px;
				height: 34px;
				text-align: center;
				float: left;
			}
			.div-box .div-number .div-box-jisuan .div-input-dao{
				margin-left: 20px;
				float: left;
				width: 50px;
				height: 38px;
				border: 1px solid aliceblue;
			}
			.div-box .div-number .div-box-jisuan .div-input-dao .div-input-dao-jian,.div-input-dao-jia{
				font-size: 20px;
				font-family: "楷体";
				float: left;
				background-color:#FC7E31;
				text-align: center;
				line-height:19px;
				width: 50px;
				cursor: pointer;
				height: 19px;
				border-bottom-left-radius: 3px;
				border-bottom-right-radius: 3px;
				border-top-left-radius: 3px;
				border-top-right-radius: 3px;
				color:#FFFFFF;
			}
			.div-box .div-number .div-box-jisuan .div-input-dao .div-input-dao-jian{
				margin-bottom: 0.5px;
			}
			.div-box .div-number .div-box-jisuan .div-input-dao .div-input-dao-jia{
				margin-top: 0.5px;
			}
			
		</style>
		<script>
			$(function(){
				var $jian=$(".div-input-dao-jian");
				var $jia=$(".div-input-dao-jia");
				var $number =$(".div-input-number");
				$jian.mousedown(function(){
					$(this).css("background-color","cornsilk");
				});
				$jian.mouseup(function(){
					$(this).css("background-color","#FC7E31");
					var oldValue = $number.val();
					var newValue = oldValue-1;
					if(newValue<1){
						$number.val(1);
						return false;
					}
					$number.val(newValue);
					return false;
				});
				$jia.mousedown(function(){
					$(this).css("background-color","cornsilk");
				});
				$jia.mouseup(function(){
					$(this).css("background-color","#FC7E31");
					var oldValue = $number.val();
					var newValue = oldValue*1+1;
					if(newValue>100){
						$number.val(100);
						return false;
					}
					$number.val(newValue);
					return false;
				});
				
				$number.keyup(function(){
  					var rex=/^[0-9]{1,3}$/;
  					if(!rex.test($number.val())){
  						$number.val(1);
  					}
  					if($number.val()<1){
  						$number.val(1);
  					}
  					if($number.val()>100){
  						$number.val(100);
  					}
				});
				//添加到购物车中
				$(".div-goshopCar").click(function(){
					window.location.href="${pageContext.request.contextPath }/goShop.do?method=addShopCar&prodcutNumber="+$(".div-input-number").val()+"&productId="+${pdif.productId};
				});
			});
		</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${pageContext.request.contextPath }/images/logo.gif" /></div>
	<div class="help"><a href="#" class="shopping">购物车</a><a href="${pageContext.request.contextPath }/login.jsp">登录</a><a href="${pageContext.request.contextPath }register.jsp">注册</a><a href="${pageContext.request.contextPath }guestbook.jsp">留言</a></div>
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
	您现在的位置：<a href="index.jsp">易买网</a> &gt; <a href="product-list.jsp">图书音像</a> &gt; 图书
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<dt>图书音像</dt>
				<dd><a href="product-list.jsp">图书</a></dd>
				<dd><a href="product-list.jsp">音乐</a></dd>
				<dt>百货</dt>
				<dd><a href="product-list.jsp">运动健康</a></dd>
				<dd><a href="product-list.jsp">服装</a></dd>
				<dd><a href="product-list.jsp">家居</a></dd>
				<dd><a href="product-list.jsp">美妆</a></dd>
				<dd><a href="product-list.jsp">母婴</a></dd>
				<dd><a href="product-list.jsp">食品</a></dd>
				<dd><a href="product-list.jsp">手机数码</a></dd>
				<dd><a href="product-list.jsp">家具首饰</a></dd>
				<dd><a href="product-list.jsp">手表饰品</a></dd>
				<dd><a href="product-list.jsp">鞋包</a></dd>
				<dd><a href="product-list.jsp">家电</a></dd>
				<dd><a href="product-list.jsp">电脑办公</a></dd>
				<dd><a href="product-list.jsp">玩具文具</a></dd>
				<dd><a href="product-list.jsp">汽车用品</a></dd>
			</dl>
		</div>
	</div>
	<div id="product" class="main">
		<h1>${pdif.productName}</h1>
		<div class="infos">
			<div class="thumb"><img src="${pageContext.request.contextPath }/images/product/${pdif.imgUrl}" width="180px" height="180px"/>
			</div>
			<div class="buy">
				<p>商城价：<span class="price" style="font-size:15px;">￥${pdif.productPrice}</span></p>
				<c:if test="${pdif.productRepo>0}">
					<p>是否有货:有货</p>
				</c:if>
				<c:if test="${pdif.productRepo<=0}">
					<p>是否有货:无货</p>
				</c:if>
					<p>储存:${pdif.productRepo}件</p>
					<div class="div-box">
					<div class="div-number">
						<span class="span-number">数量</span>
						<div class="div-box-jisuan">
							<input type="text"  class="div-input-number" value="1"/>
							<div class="div-input-dao">
								<div class="div-input-dao-jian">-</div>
								<div class="div-input-dao-jia">+</div>
							</div>
						</div>
					</div>
					<div class="div-btn">
						<div class="div-go">
							直接购买
						</div>
						<div class="div-goshopCar">
							添加购物车
						</div>
					</div>
				</div>
			</div>
			<div class="clear">
				
			</div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				名称:${pdif.productName}<br />
				类型:${pdif.productChildNick}<br />
				品牌:${pdif.productPingpaiName}<br />
				价格:${pdif.productPrice}￥<br />
				储存量:${pdif.productRepo}件<br />
				编码:${pdif.tiaoxingma}<br />
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