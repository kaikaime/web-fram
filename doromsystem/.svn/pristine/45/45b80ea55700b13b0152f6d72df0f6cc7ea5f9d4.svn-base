<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="ftm"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<title>违规记录添加</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/violation.css" />
		<script src="${pageContext.request.contextPath}/jquery/jquery-3.1.1.js"></script>
		<script src="${pageContext.request.contextPath}/js/allstudentinfor.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js" ></script>
		<style>
			*{
				padding: 0px;
				margin: 0px;
			}
			.div-body{
				border: 1px solid blue;
				width: 500px;
				height: 600px;
			}
			.div-head{
				width:500px;
				height:80px;
				border: 1px solid blue;
				background-color: blue;
				font-size: 40px;
				line-height: 80px;
				font-family: "楷体";
				color: #FFFFFF;
			}
			.div-body-form{
				width:500px;
				height:500px;
				border: 1px solid blue;
			}
			table{
				width: 440px;
				height: 500px;
				border: 1px solid blue;
				border-collapse: collapse;
			}
			tr{
				border: 1px solid blue;
			}
			td{
				border: 1px solid blue;
			}
			.td-title{
				color: red;
			}
			.input-text{
				width: 160px;
				height: 20px;
				background-color: #FFFFFF;
				color: #000000;
			}
			.submit-btn{
				width: 160px;
				height: 40px;
				background-color: blue;
				color: #FFFFFF;
				border: 0px solid #FFFFFF;
				font-size: 20px;
			}
			input,select{
				border: 1px solid blue;
			}
			.div-textarea{
				width: 300px;
				height: 100px;
			}
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
			 		违规记录添加
			 	</div>
			 	<div class="div-body-form">
			 		<form action="${pageContext.request.contextPath }/violation/update?method=update" method="get" name="ViolationBean" >
			 			<table  cellpadding="0" cellspacing="0">
			 				<tr>
			 				<td colspan="2">
			 					<input type="hidden" value="${violation.violationId}" name="violationId"/>
			 					<input type="hidden" value="${violation.student.studentId}" name="studentId"/>
			 					<input type="hidden" value="${violation.student.room.roomId}" name="roomId"/>
			 					<input type="hidden" value="${violation.student.room.ridgepole.ridgId}" name="ridId"/>
			 					<input type="hidden" value="${violation.student.classt.classId}" name="clastId"/>
			 					<input type="hidden" value="${violation.student.classt.yarddept.yardId}" name="yardId"/>
			 				</td>
			 				</tr>
			 				<tr>
			 					<td><label class="td-title">*</label>姓名:</td>
			 					<td><input type="text" class="input-text" value="${violation.student.studentNick}" name="nick"/></td>
			 				</tr>
			 				<tr>
			 					<td><label class="td-title">*</label>性别:</td>
			 					<td>
			 						<input type="text" class="input-text sex" value="${violation.student.studentSex}" name="sex" />
			 						<select class="div-sex-select">
			 							<option value="男">男</option>
			 							<option value="女">女</option>
			 						</select>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td><label class="td-title" >*</label>学院:</td>
			 					<td>
			 						<input type="text" class="input-text dept"  value="${violation.student.classt.yarddept.yardNick}" name="yard"/>
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
			 						<input type="text" class="input-text classt"  value="${violation.student.classt.classNick}" name="classt"/>
			 						<select class="div-class-select">
			 							
			 						</select>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td><label class="td-title">*</label>电话号码:</td>
			 					<td><input type="text" class="input-text" value="${violation.student.studentTel}" name="tel"/></td>
			 				</tr>
			 				<tr>
			 					<td><label class="td-title">*</label>身份证号:</td>
			 					<td><input type="text" class="input-text" value="${violation.student.studentIdCard}" name="idcard"/></td>
			 				</tr>
			 				<tr>
			 					<td><label class="td-title">*</label>现住宿舍:</td>
			 					<td>
			 						<input type="text" class="input-text room" name="room" value="${violation.student.room.ridgepole.ridgNick}${violation.student.room.roomNick}"/>
			 						<select class="div-select-room">
			 							
			 						</select>
			 						<select class="div-select-option"></select>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td><label class="td-title">*</label>违规时间:</td>
			 					
			 					<td><input type="text" class="input-text" name="viotime" onfocus="new WdatePicker(this)" value="<ftm:formatDate value="${violation.violationTime}" pattern="yyyy-MM-dd"/>"/></td>
			 				</tr>
			 				<tr>
			 					<td><label class="td-title">*</label>违规描述:</td>
			 					<td>
			 						<textarea class="div-textarea" name="viodesc">${violation.violationDesc}</textarea>
			 					</td>
			 				</tr>
			 				<tr>
			 					<td colspan="2">
			 						<center>
			 							<input type="submit" class="submit-btn" value="添&nbsp;加"></input>
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