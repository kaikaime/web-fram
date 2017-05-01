<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>宿舍管理系统</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" />
		<script src="${pageContext.request.contextPath}/jquery/jquery-3.1.1.js"></script>
		
		<script>
			$(function(){
				var iframeSrc= $("#iframe");
				$(".btn").eq(0).click(function(){iframeSrc.attr("src","indexpage.jsp");});
				$(".btn").eq(1).click(function(){iframeSrc.attr("src","${pageContext.request.contextPath}/student/findAll?method=findAll");});
				$(".btn").eq(2).click(function(){iframeSrc.attr("src","${pageContext.request.contextPath}/violation/findAll?method=findAll");});
				$(".btn").eq(3).click(function(){iframeSrc.attr("src","${pageContext.request.contextPath}/vaction/findAll?method=findAll");});
				$(".btn").eq(4).click(function(){iframeSrc.attr("src","${pageContext.request.contextPath}/health/findAll?method=findAll");});
				$(".btn").eq(5).click(function(){iframeSrc.attr("src","${pageContext.request.contextPath}/excell/findAll?method=findAll");});
			
				var alertDialog=$(".div-alertDialog");
				$(".div-modify-btn").click(function(){
				$(".div-input-text").val("");
					alertDialog.fadeIn(300);
				});
					
				$(".cancel").click(function(){
					alertDialog.fadeOut(300);
					
				})
					//表单校验
					$("form").method="post";
					$("form").action="javascript:void(0);";
					$("form").name="user";
					$("form").submit(function(){
						var rex = /^[1-9_a-zA-Z][0-9_a-zA-Z]{5,7}$/;
						if(!rex.test($(".oldpass").val())){
							var erroMsg="请输入6到8位的字符或数字!";
							$.textChange($(".oldpass"),erroMsg);
							return false;
						}else if(!rex.test($(".newpass").val())){
							var erroMsg="请输入6到8位的字符或数字!";
							$.textChange($(".newpass"),erroMsg);
							return false;
						}else if($(".newpass").val()!=$(".twopass").val()){
							var erroMsg="两次密码不一致!";
							$.textChange($(".twopass"),erroMsg);
							return false;
						}else{
							//ajax提交
							return true;
						}
				});
				
				//用户注销登录
				$(".logout").bind("click",function(){
					if(confirm("你确定要退出登录吗!")){
						$.get("${pageContext.request.contextPath}/logout.do?method=logout",function(data){
						 if(data="true"){
								window.location.href="${pageContext.request.contextPath}/login.jsp";
							}
						},"text"); 
					}
				});
			});
			//修改密码框属性值动态改变
			jQuery.textChange=function(obj,erro){
					obj.css("font-size","10px")
							.css("color","#FF0000")
							.attr("type","text")
							.css("font-family","楷体")
							.val(erro).focus(function(){
								obj.val("")
								.attr("type","password")
								.css("color","#000000");
				});
			}
		</script>
	</head>
	<body>
		<div class="div-body">
			<div class="div-head">
				<div class="div-head-title">宿舍管理系统</div>
				<div class="div-right-title">
					<span>管理员:</span>
					<span>吕凯雪</span>
					<input type="button" class="div-modify-btn" value="修改密码"></input>
					<input type="button" class="logout" value="注销"/></button>
				</div>
			</div>
			<!--左边内容-->
			<div class="div-left-body">
				<ul>
					<li>
						<button type="button" class="btn">
							<span>首&nbsp;&nbsp;&nbsp;&nbsp;页</span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span>+</span>
						</button>
					</li>
					<li>
						<button type="button" class="btn" >
							<span>宿舍学生</span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span>+</span>
						</button>
					</li>
					<li>
						<button type="button" class="btn" >
							<span>违规纪录</span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span>+</span>
						</button>
					</li>
					<li>
						<button type="button" class="btn">
							<span>请假纪录</span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span>+</span>
						</button>
					</li>
					<li>
						<button type="button" class="btn" >
							<span>宿舍卫生</span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span>+</span>
						</button>
					</li>
					<li>
						<button type="button" class="btn" >
							<span>宿舍评比</span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span>+</span>
						</button>
					</li>
				</ul>
			</div>
			<!--右边内容-->
			<div class="div-right-body">
				<iframe src="indexpage.jsp" id="iframe"></iframe>
			</div>
		</div>
		<div class="span-banquan-title">
			<span class="span-banquan-title">
					版权归个人所有&copy;
			</span>
		</div>
		<div class="div-alertDialog">
			<div class="div-alert-modify">
				<form>
					<center>
						<div class="div-modify-title">亲，你是否真的需要修改密码吗!</div>
					</center>
					<center>
						<div class="div-modify-pa">
						<label>原始密码:</label>
						<input type="password" class="div-input-text oldpass"/>
					</div>
					</center>
					<center>
						<div class="div-modify-pa">
						<label>&nbsp; 新密码:</label>
						<input type="password" class="div-input-text newpass" />
					</div>
					</center>
					<center>
						<div class="div-modify-pa">
						<label>再次输入:</label>
						<input type="password" class="div-input-text twopass"/>
					</div>
					</center>
					<center>
						<div class="div-modify-pa btns-div">
						<input type="submit" value="确定" class="modify-btn ok"/>
						<input type="button" value="取消" class="modify-btn cancel"/>
					</div>
					</center>
					
				</form>
				
			</div>
		</div>
	</body>
</html>
