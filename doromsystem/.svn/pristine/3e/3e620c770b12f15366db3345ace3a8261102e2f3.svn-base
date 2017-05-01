<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>添加学生信息</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/allstudent.css" />
		<script src="${pageContext.request.contextPath}/jquery/jquery-3.1.1.js"></script>
		<script src="${pageContext.request.contextPath}/js/allstudentinfor.js"></script>
		<style>
			
		</style>
		<script>
			$(function(){
				jQuery.loadObj();
				jQuery.loadRoom();
			});
		</script>
	</head>
	<body>
		<center>
			<div class="div-body">
			 	<div class="div-head">
			 		学生信息添加
			 	</div>
			 	<div class="div-body-form">
			 		<form>
			 			<table  cellpadding="0" cellspacing="0">
			 				<tr>
			 					<td><label class="td-title">*</label>姓名:</td>
			 					<td><input type="text" class="input-text"/></td>
			 				</tr>
			 				<tr>
			 					<td><label class="td-title">*</label>性别:</td>
			 					<td>
			 						<input type="text" class="input-text sex" value="男" disabled="disabled"/>
			 						<select class="div-sex-select">
			 							<option value="男">男</option>
			 							<option value="女">女</option>
			 						</select>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td><label class="td-title" >*</label>学院:</td>
			 					<td>
			 						<input type="text" class="input-text dept" disabled="disabled" value="商务学院"/>
			 						<select class="div-dept-select">
			 							<option value="0">商务学院</option>
			 							<option value="1">经贸学院</option>
			 							<option value="2">机械学院</option>
			 							<option value="3">冶金学院</option>
			 							<option value="4">汽车学院</option>
			 							<option value="5">生物工程学院</option>
			 						</select>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td><label class="td-title">*</label>班级:</td>
			 					<td>
			 						<input type="text" class="input-text classt" disabled="disabled"/>
			 						<select class="div-class-select">
			 							
			 						</select>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td><label class="td-title">*</label>电话号码:</td>
			 					<td><input type="text" class="input-text"/></td>
			 				</tr>
			 				<tr>
			 					<td><label class="td-title">*</label>身份证号:</td>
			 					<td><input type="text" class="input-text"/></td>
			 				</tr>
			 				<tr>
			 					<td><label class="td-title">*</label>现住宿舍:</td>
			 					<td>
			 						<input type="text" class="input-text room" disabled="disabled"/>
			 						<select class="div-select-room">
			 							
			 						</select>
			 						<select class="div-select-option"></select>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td colspan="2">
			 						<center>
			 							<input type="submit" class="submit-btn"></input>
			 						</center>
			 						
			 					</td>
			 				</tr>
			 			</table>
			 		</form>
			 	</div>
			</div>
		</center>
		
	</body>
</html>
