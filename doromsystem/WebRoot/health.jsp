<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script src="${pageContext.request.contextPath}/jquery/jquery-3.1.1.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/health.css" />
		<script>
			$(function(){
				$("#check-all").click(function(){
					$(":checkbox").attr("checked",$(this).is(":checked"));
				});
			});
		</script>
	</head>
	<body>
		<div class="div-body">
			<div class="div-head">
				<label class="div-leable">宿舍卫生</label>
				<div class="div-tiaojian">
					<input class="text-nick" type="text" placeholder="宿舍" />
					<input type="button" class="btn-nick" value="搜索" />
					<input type="button" class="btn-nick" value="添加纪录" />
				</div>
			</div>
			
			<div class="div-table-body">
				<table cellpadding="0" cellspacing="0">
					<tr  height="30" class="table-tr">
						<th width="70">
							<input type="checkbox" id="check-all">&nbsp;全选</input>
						</th>
						<th>宿舍</th>
						<th>时间</th>
						<th>扣分情况</th>
						<th>卫生等级</th>
						<th>卫生描述</th>
						<th></th>
					</tr>
					<c:forEach items="${itemlist }" var="itemlist">
						<tr height="30" class="table-tr">
							<td width="100">
								<input type="checkbox">&nbsp;选择</input>
							</td>
							
							<td>${itemlist.roomNick }</td>
							<td>${itemlist.formatDate }</td>
							<td>扣${itemlist.markNumber}分&nbsp;${itemlist.markDesc}</td>
							<td>${itemlist.state}&nbsp;原因:&nbsp;${itemlist.stateDesc}</td>
							<td>${itemlist.healthDesc}</td>
							<td>
								<a href="${pageContext.request.contextPath}/health/findById/${itemlist.healthId}/${itemlist.markId}/${itemlist.stateId}/${itemlist.roomId}/${itemlist.ridgId}">修改</a>&nbsp;
								<a href="${pageContext.request.contextPath}/health/delete?method=delete&healthId=${itemlist.healthId}&markId=${itemlist.markId}&stateId=${itemlist.stateId}">删除</a>
							</td>
						</tr>
					</c:forEach>
					
					
				</table>
				<div class="fenye-div">
				<center class="div-center">
				显示第<span>${allObjCount<=0?0:(allObjCount<=13*pageId?(13*(pageId-1)+1):(allObjCount<1?0:1))}</span>至<span>${allObjCount>pageId*13?pageId*13:allObjCount}</span>项纪录，
				共<span>${pageCount<1?1:pageCount}</span>页</center>
					<div class="div-left-footer">
						<a href="${pageContext.request.contextPath}/health/findAll?method=finaAll&pageId=${pageId<=1?1:pageId-1}"><label class="div_up">上一页</label></a>
						<span class="div_center">${pageId<1?1:pageId}</span>
						<a href="${pageContext.request.contextPath}/health/findAll?method=finaAll&pageId=${(pageCount*10-allObjCount)<=13?(pageId<=1?pageId+1:pageId):(pageId+1)}"><label class="div_down">下一页</label></a>
					</div>
				</div>
				</div>
			</div>
		</div>
	</body>
</html>
