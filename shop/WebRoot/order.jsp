<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jsadd.js" ></script>
<style>
	
	
	
</style>
<script>
	$(function(){
		addressInit('cmbProvince', 'cmbCity', 'cmbArea');
		var inputPro = $(".input-conent-add");
		var proValue = $("#cmbProvince");
		var cityValue =$("#cmbCity");
		var areat = $("#cmbArea");
		
		//设置默认的地址
		inputPro.eq(0).val(proValue.eq(0).val()+"/"+cityValue.eq(0).val()+"/"+areat.eq(0).val());
		proValue.change(function(){
		 	var shen = $(this).val();
		 	cityValue.change(function(){
			 var city = $(this).val();
			 	areat.change(function(){
			 		var qu = $(this).val();
			 		inputPro.eq(0).val(shen+"/"+city+"/"+qu);
		 		});
			});
		});
		 	
		 $(".save").click(function(){
		 	if(inputPro.val()==""){
		 		alert("请输入地址!");
		 		return false;
		 	}else if($("#texts").val()==""){
		 		alert("请输入详情地址!");
		 			return false;
		 	}else if($(".div-tel").eq(0).val()==""){
		 		alert("请输入联系方式!");
		 			return false;
		 	}else if($(".div-tel").eq(1).val()==""){
		 		alert("请输入发货人!");
		 			return false;
		 	}else{
		 		$(".div-edit").hide(200);
		 	};
		 });
		 	
		//添加地址框的显示
		$(".div-manage").click(function(){
				$(".div-edit").show(200);
				$(".save").val("保存");
			});
			
		//地址切换	
		{
			setValue($(".div_add_show"));
			var divObj=null;	
			$(".div_add_show").click(function(){
				$(this).css("background-color","#FFF0D9");
				setValue($(this));
				if(divObj!=null){
					if(!$(this).is(divObj)){
						divObj.css("background-color","#FFFFFF");
					}else{
						//进入编辑状态
						$(".div-edit").show(200);
						$(".save").val("修改");
						if(divObj!=null){
							$(".input-conent-add").val(divObj.find("span").eq(0).text());
							$(".div-tel").eq(0).val(divObj.find("span").eq(3).text());
							var tel = divObj.find("span").eq(1).text().split("(收)")[0];
							$(".div-tel").eq(1).val(tel);
						}
					};
				};
				divObj = $(this);
				loadAdd(divObj);
			});
			//页面第一开始加载的时候，设置为第一个为默认地址
			var firstDiv = $(".div_add_show").eq(0);
			firstDiv.css("background-color","#FFF0D9");
			loadAdd(firstDiv);
			divObj = firstDiv;
		}
		
		//焦点失重
		var divAddObj = $(".divs-click");
		var cIndex = -2;
		divAddObj.on("click",function(){
				var index = $(this).index($(".divs-click"));//索引值
				if(index==-1){
					cIndex=index;
				}else if(index==0&&cIndex==-1){	//不取消
					cIndex = -2;
				}else{//取消
					$(".div-edit").hide(200);
				}
			});
			
			
		//地址提交
		var urls = "${pageContext.request.contextPath}/order.do?method=submitOrderAdd&methods=";
		var $orderForm = $(".order_add_form");
		$orderForm.attr("method","post");
		$(".order_add_form").submit(function(){
			if($(".save").val()=="保存"){//添加地址
				$orderForm.attr("action",urls+"save");
				return true;
			}else if($(".save").val()=="修改"){
				$orderForm.attr("action",urls+"update");
				return true;
			}
		});
		
	});
	
	function loadAdd(divObj){
			$(".div-box-font").text(divObj.find("span").eq(0).text());
			$(".div-user-nick").text(divObj.find("span").eq(1).text());
			$(".div-box-tel").text(divObj.find("span").eq(3).text());
	}
	
	function setValue(obj){
		var radId = obj.find(".in_radId").val();//地址Id
		var cusId = obj.find(".in_cusId").val();//收货人Id
		$(".radId-form").val(radId);
		$(".curId-form").val(cusId);
	}
	
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
	您现在的位置：<a href="index.html">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<div class="div-head">
			<div class="div_shouhuo">
				收货地址
			</div>
			<div class="div_add_infor">
			<c:forEach items="${radList}" var="item">
				<c:forEach items="${item.list}" var="it">
				<div class='div_add_show'>
					<input  type="hidden" value="${item.radId}" class="in_radId"/>
					<input  type="hidden" value="${it.customerId}" class="in_cusId"/>
					<div class='div-add-center-show'>
						<div class='div-font'>
							<c:if test="${item.radxq==null}">
								<span class='span-adds'>${item.rad}</span>
							</c:if>
							<c:if test="${item.radxq!=null}">
								<span class='span-adds'>${item.rad}/${item.radxq}</span>
							</c:if>
							&nbsp;<span>${it.customerNick}(收)</span>
						</div>
						<div class='div-font-add'>
							<span>联系方式:</span>&nbsp;
							<span>${it.customerTel}</span>
						</div>
						<!-- <div class='div-font-delelte'>
							<span>删除</span>
						</div> -->
					</div>
				</div>
				</c:forEach>
			</c:forEach>
			</div>
			<span class="div-manage">
				管理地址
			</span>
			<div class="div-order-info">
				<span class="div-order-title">订单信息</span>
				<ul class="div-order-ul">
					<li class="div-li-nick"></li>
					<li class="div-pro-li">商品名称</li>
						<li class="div-pro-li">类型</li>
							<li class="div-pro-li">单价</li>
								<li class="div-pro-li">数量</li>
									<li class="div-pro-li">小计</li>
										
				</ul>
				<ul class="div-shop-ul">
					<li class="div-li-shop">
						<center>
							<img src="${pageContext.request.contextPath}/images/product/${order.imgUrl}" width="60px" height="60px" class="img"/>
						</center>
					</li>
					<li class="div-shop-li">${order.productName}</li>
						<li class="div-shop-li">${order.productChildNick}</li>
							<li class="div-shop-li">${order.productPrice}￥</li>
								<li class="div-shop-li">${order.shopNumber}件</li>
									<li class="div-shop-li">${order.shopNumber*1*order.productPrice}￥</li>
				</ul>
				<div class="div-line" ></div>
				<form action="${pageContext.request.contextPath }/order.do?method=submitOrder" method="post">
					<input type="hidden" name="radId" class="radId-form"/> 
 					<input type="hidden" name="cusId" class="curId-form"/>
 					<input type="hidden" value="${order.productId}" name="productId"/>
 					<input type="hidden" value="${order.shopNumber}" name="number" />
				<div class="div-box">
					<div class="div-box-money">
						<div class="div-money">付款:</div>
						<div class="div-money money">${order.shopNumber*1*order.productPrice}￥</div>
					</div>
					<div class="div-box-adds">
						<span class="div-box-add">寄送至</span>
						<span class="div-box-font">广东珠海香洲前山金鸡西路789号格力康乐园</span>
					</div>
					<div class="div-box-nick">
						<span class="div-user-nick">吕凯雪:</span>
						<span class="div-box-tel">18873341425</span>
					</div>
				</div>
				<input type="submit" class="div-submit" value="提交订单">
			</form>
			</div>
		</div>
	</div>
</div>
<div class="div-edit divs-click">
		<div class="div-center divs-click">
			<form  class="order_add_form">
<%-- 			action="${pageContext.request.contextPath}/order.do?method=submitOrderAdd&methods=save"
 --%>			<div class="div-add-wr">地址填写
 					<input type="hidden" name="radId" class="radId-form"/> 
 					<input type="hidden" name="cusId" class="curId-form"/>
 					<input type="hidden" value="${order.productId}" name="productId"/>
 					<input type="hidden" value="${order.shopNumber}" name="number" />
 				</div>
			<div class="div-left">
				<span>所在的地区:</span>
				<input type="text" name="add" class="input-conent-add" style="width: 150px; height: 25px;"  />
				<select id="cmbProvince" style="height: 25px;"  ></select>
				<select id="cmbCity" style=" height: 25px;"  ></select>
				<select id="cmbArea" style=" height: 25px;"  ></select>
			</div>
			<div class="div-texts">
				<textarea placeholder="详情地址" id="texts" name="radxq"></textarea>
				<input type="text" placeholder="联系方式" class="div-tel" name="tel" />
				<input type="text" placeholder="收货人姓名" class="div-tel" name="customer"  />
				<input type="submit" class="save" value="保存"></input>
			</div>
			</form>
				<!---->
		</div>
	
</div>
<div id="footer">
	Copyright &copy; 易买网 All Rights Reserved. 京ICP证1000001号
</div>

</body>
</html>