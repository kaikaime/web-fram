<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/student.css" />
	</head>
	<body>
		<div class="div-body">
			<div class="div-head">
				宿舍学生
			</div>
			<div class="div-table-body">
				<table cellpadding="0" cellspacing="0">
					<c:forEach items="${list }" var="item">
						<tr height="30" class="table-tr">
							<td width="100">${item.ridgepole.ridgNick}${item.roomNick}</td>
							<c:forEach items="${item.student}" var="stu">
								<td>${stu.studentNick}</td>
							</c:forEach>
						</tr>
					</c:forEach>
				</table>
				<div class="fenye-div">
				<center class="div-center">
				显示第<span>${allObjCount<=0?0:(allObjCount<=13*pageId?(13*(pageId-1)+1):(allObjCount<1?0:1))}</span>至<span>${allObjCount>pageId*13?pageId*13:allObjCount}</span>项纪录，
				共<span>${pageCount<1?1:pageCount}</span>页</center>
					<div class="div-left-footer">
						<a href="${pageContext.request.contextPath}/student/findAll?method=findAll&pageId=${pageId<=1?1:pageId-1}"><label class="div_up">上一页</label></a>
						<span class="div_center">${pageId<1?1:pageId}</span>
						<a href="${pageContext.request.contextPath}/student/findAll?method=findAll&pageId=${(pageCount*10-allObjCount)<=13?(pageId<=1?pageId+1:pageId):(pageId+1)}"><label class="div_down">下一页</label></a>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
