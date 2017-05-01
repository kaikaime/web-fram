<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/addvication.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-3.1.1.js"></script>
	</head>
	<script type="text/javascript">
		$(function(){
		
		});
		
	</script>
	<body>
		<center>
			<div class="div-body">
			
			<form action="${pageContext.request.contextPath}/vaction/update?method=update" method="post">
				<input type="submit" class="div-btn" value="添加请假记录"></input>
				<div class="div-nick">
					<input type="hidden" value="${vaction.vactionId}" name="vactionsId"/>
					<input type="hidden" value="${vaction.student.studentId}" name="vactionsId"/>
					<input type="hidden" value="${vaction.student.classt.classId}" name="vactionsId"/>
					<input type="hidden" value="${vaction.student.classt.yarddept.yardId}" name="vactionsId"/>
					<input type="hidden" value="${vaction.student.room.roomId}" name="vactionsId"/>
					<input type="hidden" value="${vaction.student.room.ridgepole.ridgId}" name="vactionsId"/>
					<label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label>&nbsp;
					<input type="text" class="input-text-nick" value="${vaction.student.studentNick}" name="studentNick"/>
				</div>
				<div class="div-nick">
					<label>院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部:</label>&nbsp;
					<input type="text" class="input-text-nick" value="${vaction.student.classt.yarddept.yardNick}" name="yardNick"/>
				</div>
				<div class="div-nick">
					<label>班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级:</label>&nbsp;
					<input type="text" class="input-text-nick" value="${vaction.student.classt.classNick}" name="classNick" />
				</div> 
				<div class="div-nick">
					<label>宿&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;舍:</label>&nbsp;
					<input type="text" class="input-text-nick" value="${vaction.student.room.ridgepole.ridgNick}${vaction.student.room.roomNick}" name="roomNick" />
				</div>
				<div class="div-nick">
					<label>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</label>&nbsp;
					<input type="text" class="input-text-nick" value="${vaction.student.studentTel}" name="studentTel"/>
				</div>
				<div class="div-nick">
					<label>开始时间:</label>&nbsp;
					<input type="text" class="input-text-nick" name="startTime" value="<fmt:formatDate value="${vaction.startTime}" pattern="yyyy-MM-dd"/>" onfocus="new WdatePicker(this)"/>
					
				</div>
				<div class="div-nick">
					<label>结束时间:</label>&nbsp;
					<input type="text" class="input-text-nick" name="endTime" value="<fmt:formatDate value="${vaction.endTime}" pattern="yyyy-MM-dd"/>" onfocus="new WdatePicker(this)"/>
				</div>
				<div class="div-nick ssMenu">
					<label class="div-ssm">请假原因:</label>&nbsp;
					<textarea class="div-textarea"  name="vactionDesc" >${vaction.vactionDesc}</textarea>
				</div>
				
			</div>
		</form>
		</center>
		
	</body>
</html>


