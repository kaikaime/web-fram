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
		<script src="${pageContext.request.contextPath}/jquery/jquery-3.1.1.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/excellent.css" />
		<script>
			$(function(){
				$("#check-all").click(function(){
					$(":checkbox").attr("checked",$(this).is(":checked"));
				});
				$(".btn-nick:eq(1)").click(function(){
					window.location.href="${pageContext.request.contextPath}/excell/findfirst";
					
				});
				
				//模糊查询
					$("#search").click(function(){
					var rexRoom = /^[1-9]{1,5}$/;
						var rexState =/^[a-zA-Z]$/;
					
						if(rexRoom.test($(".text-nick").val())){
							$.get("${pageContext.request.contextPath}/excell/findRoom",{
								"roomNick":""+$(".text-nick").val(),
								"pageId":"1"
							});
							return true;
						}else if(rexState.test($(".text-nick").val())){
							$.get("${pageContext.request.contextPath}/excell/findRoom",{
								"roomNick":""+$(".text-nick").val(),
								"pageId":"1"
							});
							return true;
						}
							return false;
				});
			});
		</script>
		
	</head>
	<body>
		<div class="div-body">
			<div class="div-head">
				<label class="div-leable">宿舍评比</label>
				<div class="div-tiaojian">
					<input class="text-nick" type="text" placeholder="宿舍/等级" />
					<input type="button" class="btn-nick" value="搜索" id="search" />
					<input type="button" class="btn-nick" value="取消" />
				</div>
			</div>
			
			<div class="div-table-body">
				<table cellpadding="0" cellspacing="0">
					<tr  height="30" class="table-tr">
						<th width="70">
							<input type="checkbox" id="check-all">&nbsp;全选</input>
						</th>
						<th>宿舍</th>
						<th>评比时间</th>
						<th>宿舍等级</th>
						<th>宿舍讲评</th>
						<th>不足点</th>
						<th></th>
					</tr>
					
				<c:forEach items="${ListBean}" var="itemslist" varStatus="index" step="1">
					<tr height="30" class="even">
						<td width="100">
							<input type="checkbox">&nbsp;选择</input>
						</td>
						<td>${itemslist.roomNick}</td>
						<td>${itemslist.formatDate}</td>
						<td>${itemslist.excellentState}</td>
						<td>${itemslist.excellentDesc}</td>
						<td>${itemslist.excellentLack}</td>
						<td>
							<a href="javascript:void(0);">修改</a>&nbsp;
							<a href="${pageContext.request.contextPath}/excell/delete?id=${itemslist.excellentId}">删除</a>
						</td>
					</tr>
				</c:forEach>
				</table>
				
				<div class="fenye-div">
				<center class="div-center">
				显示第<span>${allObjCount<=13*pageId?(13*(pageId-1)+1):(allObjCount<1?0:1)}</span>至<span>${allObjCount>pageId*13?pageId*13:allObjCount}</span>项纪录，
				共<span>${pageCount<1?1:pageCount}</span>页</center>
					<div class="div-left-footer">
						<a href="${pageContext.request.contextPath}/excell/findAll?pageId=${pageId==1?pageId:pageId-1}"><label class="div_up">上一页</label></a>
						<span class="div_center">${pageId<1?1:pageId}</span>
						<a href="${pageContext.request.contextPath}/excell/findAll?pageId=${(pageCount*10-allObjCount)<=13?(pageId==1?pageId+1:pageId):(pageId+1)}"><label class="div_down">下一页</label></a>
					</div>
				</div>
			</div>
		</div>
		
	</body>
</html>
