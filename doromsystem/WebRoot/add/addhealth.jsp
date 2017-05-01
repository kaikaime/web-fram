<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-3.1.1.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/addhealth.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/My97DatePicker/WdatePicker.js" ></script>
	</head>
	<style>
		*{
			padding: 0px;
			margin: 0px;
		}
		.div-body{
			width: 700px;
			height: 400px;
			border: 1px solid blue;
			margin-top: 50px;
		}
		.div-head{
			height: 50px;
			width: 700px;
			border: 1px solid blue;
			position: absolute;
			line-height:50px ;
		}
		.room{
			width: 100px;
			height: 20px;
		}
		.div-title{
			height: 80px;
			width: 700px;
			line-height: 80px;
			font-family: "楷体";
			font-size: 40px;
			color: white;
			background-color: blue;
			border: 1px solid blue;
		}
		.div-textarea{
			margin-top: 70px;
			width: 500px;
			height: 200px;
			float: left;
			margin-left: 20px;
			font-family: "楷体";
		}
		.div-mark-desc{
			margin-top: 70px;
			float: left;
			margin-left: 50px;
			font-family: "楷体";
		}
		label{
			font-family: "楷体";
		}
		.rooms{
			background-color:#FFFFFF ;
			
		}
	</style>
	<script>
		$(function(){
				jQuery.roomChange();
			});
	</script>
	</heal>
	<body>
		
			
				<center>
					<div class="div-body">
						<form method="get" name="HealthBean" action="${pageContext.request.contextPath}/health/modify">
							<button type="submit" class="div-title">宿舍卫生记录添加</button>
							<div class="div-head">
										<input type="hidden" value="${healthBean.ridgId }" name="ridgId"/>
										${healthBean.ridgId }
										<input type="hidden" value="${healthBean.roomId }" name="roomId"/>
										<input type="hidden" value="${healthBean.stateId }" name="stateId"/>
										<input type="hidden" value="${healthBean.healthId }" name="healthId"/>
										<input type="hidden" value="${healthBean.markId }" name="markId"/>
										<input type="hidden" value="${healthBean.rmId }" name="rmId"/>
										
										<label class="td-title">宿舍:</label>
				 						<input type="text" class="input-text room rooms" name="formatRoom" value="${healthBean.ridgNick }-${healthBean.roomNick}" />
				 						<select class="div-select-room"   >
				 						</select>
				 						<select class="div-select-option"  ></select>&nbsp;&nbsp;
				 						<label class="td-title">扣分:</label>
				 					    <input type="text" class="input-text room " name="markNumber" value="${healthBean.markNumber}" />&nbsp;&nbsp;
										<label class="td-title">检查时间:</label>
										<input type="text" class="input-text room"  name="formatDate"  value="<fmt:formatDate value='${ healthBean.markTime}' pattern='yyyy-MM-dd'/>"  onfocus="new WdatePicker(this)"/>
								</div>
							<div>
								<label class="div-mark-desc">卫生描述:</label>&nbsp;
								<textarea class="div-textarea" name="healthDesc" >${ healthBean.markDesc}</textarea>
							</div>
						</form>
					</div>
				</center>
		</body>
</html>
