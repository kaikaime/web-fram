<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/function-manage.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-3.0.0.min.js"></script>
	<script type="text/javascript">
		$(function(){
			setInterval(function(){
			var url="${pageContext.request.contextPath }/findHeadInfo.do?method=findHeadInfo&&info=headinfor";
				$.getJSON(url,function(data){
					$(".welcome").html("管理员您好，欢迎回到管理后台。时间：&nbsp;"+data.time);
				}); 
			}, 1000);
		});
		//"+${userPojo.userMaName}+"
	</script>
</head>
<body>
<div id="childNav">
	 <div class="welcome wrap showtime"></div>  
</div>
    
</body>
</html>
