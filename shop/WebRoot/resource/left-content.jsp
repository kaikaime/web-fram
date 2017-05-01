<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="${pageContext.request.contextPath }/manage/user-add.jsp">新增</a></em><a href="${pageContext.request.contextPath }/userma.do?method=findAll&pageId=1">用户管理</a></dd>
				<dt>商品信息</dt>
				<dd><em><a href="${pageContext.request.contextPath }/manage/productClass-add.jsp">新增</a></em><a href="${pageContext.request.contextPath }/manage/productClass.jsp">分类管理</a></dd>
				<dd><em><a href="${pageContext.request.contextPath }/manage/product-add.jsp">新增</a></em><a href="${pageContext.request.contextPath }/manage/product.jsp">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="${pageContext.request.contextPath }/order.do?method=findAll">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="${pageContext.request.contextPath }/manage/guestbook.jsp">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="${pageContext.request.contextPath }/manage/news-add.jsp">新增</a></em><a href="${pageContext.request.contextPath }/manage/news.jsp">新闻管理</a></dd>
			</dl>
		</div>
	</div>
  
