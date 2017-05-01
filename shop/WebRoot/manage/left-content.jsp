<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 				<dl>
				<dt>用户管理</dt>
				<dd><em><%-- <a href="${pageContext.request.contextPath }/manage/user-add.jsp">新增</a>--%></em> <a href="${pageContext.request.contextPath }/userma.do?method=findAllUser">用户管理</a></dd>
				<dt>商品信息</dt>
				<dd><em><a href="${pageContext.request.contextPath }/manage/productClass-add.jsp">新增</a></em><a href="${pageContext.request.contextPath}/category.do?method=findAllUser">分类管理</a></dd>
				<dd><em><a href="${pageContext.request.contextPath }/manage/product-add.jsp">新增</a></em><a href="${pageContext.request.contextPath }/product.do?method=findAllUser">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="${pageContext.request.contextPath }/order.do?method=findAllOrder">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="${pageContext.request.contextPath }/manage/guestbook.jsp">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="${pageContext.request.contextPath }/manage/news-add.jsp">新增</a></em><a href="${pageContext.request.contextPath }/manage/news.jsp">新闻管理</a></dd>
				</dl>
  
