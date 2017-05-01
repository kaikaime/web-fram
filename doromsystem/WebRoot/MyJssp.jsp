<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			body{
				background-color: #39B4D3;
			}
			*{
				padding: 0px;
				margin: 0px;
			}
			.top_title{
				width: 60%;
				margin-right: 20%;
				top: 10%;
				position: absolute;
				margin-left: 20%;
				font-size: 40px;
				color: #39B4D3;
				font-family: "楷体";
				text-align: center;
			}
			.div-body{
				position: absolute;
				background-color: #FFFFFF;
				top: 5%;
				margin-left: 25%;
				margin-right: 25%;
				width: 50%;
				height:70%;
				border-bottom-right-radius: 10px;
				border-bottom-left-radius: 10px;
				border-top-right-radius: 10px;
				border-top-left-radius:10px;
				
			}
			.div-name{
				width: 50%;
				height: 10%;
				position: absolute;
				margin-left: 25%;
				margin-right: 25%;
				top: 30%;
				
			}
			.span-name{
				position: absolute;
				left: 13%;
				margin-top: 10px;
				font-family: "楷体";
				font-size: 17px;
				
			}
			.input-text-name{
				margin-top: 9px;
				position: absolute;
				right: 13%;
				height: 20px;
				width: 160px;
				border-bottom-left-radius:3px;
				border-bottom-right-radius: 3px;
				border-top-right-radius: 3px;
				border-top-left-radius: 3px;
				border: 1px solid #39B4D3;
				
			}
			
			.div-pass{
				width: 50%;
				height: 10%;
				position: absolute;
				margin-left: 25%;
				margin-right: 25%;
				top: 50%;
			}
			.span-pass{
				position: absolute;
				left: 13%;
				margin-top: 10px;
				font-family: "楷体";
				font-size: 17px;
				
			}
			.input-text-pass{
				
				margin-top: 9px;
				position: absolute;
				right: 13%;
				height: 20px;
				width: 160px;
				border-bottom-left-radius:3px;
				border-bottom-right-radius: 3px;
				border-top-right-radius: 3px;
				border-top-left-radius: 3px;
				border: 1px solid #39B4D3;
			}
			.div-login{
				width: 50%;
				height: 10%;
				position: absolute;
				margin-left: 25%;
				margin-right: 25%;
				top: 70%;
			}
			.input-submit{
				margin-top:5px;
				left: 10%;
				width: 38%;
				height: 90%;
				position: absolute;
				
			}
			.input-button{
				margin-top:5px;
				right: 10%;
				width: 38%;
				height: 90%;
				position: absolute;
				
				}
			.input-button,.input-submit{
				border-bottom-left-radius:2px;
				border-bottom-right-radius: 2px;
				border-top-right-radius: 2px;
				border-top-left-radius: 2px;
				background-color: #39B4D3;
				font-size: 20px;
				color: #FFFFFF;
				border: 0px solid blue;
				font-family: "楷体";
			}
			
			.div-footer{
				position: absolute;
				top: 90%;
				margin-left: 25%;
				margin-right: 25%;
				width: 50%;
				height:5%;
			}
			.a-right,.a-for{
				
				position: absolute;
				line-height: 100%;
				font-size: 15px;
				font-family: "楷体";
			}
			.a-right{
				left: 20%;
				
			}
			.a-for{
				right: 20%;
			}
		</style>
	</head>
	<body>
		
		<div class="div-body">
			<div class="top_title">
			宿舍管理系统登录
			</div>
			<div class="div-name">
				<span class="span-name">用户名:</span>
				<input type="text" class="input-text-name" />
			</div>
			
			<div class="div-pass">
				<span class="span-pass">密&nbsp; 码:</span>
				<input type="text" class="input-text-pass" />
			</div>
			
			<div class="div-login">
				<input type="submit" class="input-submit"  value="登&nbsp;录"/>
				<input type="button" class="input-button"  value="取&nbsp;消"/>
			</div>
			<div class="div-footer">
				<a class="a-right">注册</a>
				<a class="a-for">忘记密码</a>
			</div>
		</div>
	</body>
</html>
