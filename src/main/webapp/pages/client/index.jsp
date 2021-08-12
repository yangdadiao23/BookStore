<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function (){
/*			$("button.cart").click(function (){
                 var id = $(this).attr("bookId");
				$.getJSON("http://localhost:8080/BookStore/cartServlet","action=AjaxAddItem&id="+id,function (date){
					$("#totalCount").html("您的购物车中有"+date.totalCount+"件商品");
					$("#lastName").html(date.lastName);
				})
			})*/
			$("button.cart").click(function (){
				var id = $(this).attr("bookId");
				location.href="http://localhost:8080/BookStore/cartServlet?action=addItem&id="+id;
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<c:if test="${empty sessionScope.username}">
					<a href="pages/user/login.jsp">登录</a>
					<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
					<a href="pages/cart/cart.jsp">购物车</a>
					<a href="pages/manager/manager.jsp">后台管理</a>
				</c:if>
				<c:if test="${not empty sessionScope.username}">
					<span>欢迎<span class="um_span">${sessionScope.username}</span>光临尚硅谷书城</span>
					<a href="pages/order/order.jsp">我的订单</a>
					<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
					<a href="pages/cart/cart.jsp">购物车</a>
					<a href="pages/manager/manager.jsp">后台管理</a>
				</c:if>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/BookServlet" method="get">
					<input type="hidden" name="action" value="pageByPrice">
					价格：<input id="min" type="text" name="min" value=${param.min}> 元 -
						<input id="max" type="text" name="max"value="${param.max}">  元
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span id="totalCount">您的购物车中有${sessionScope.cart.totalCount}件商品</span>
				<c:if test="${not empty sessionScope.cart.items}">
					<div >
						您刚刚将<span id="lastName" style="color: red">${sessionScope.lastName}</span>加入到了购物车中
					</div>
				</c:if>
			</div>
			<c:forEach items="${requestScope.page.items}" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="${book.img_path}" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.name}</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">￥${book.price}</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales}</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock}</span>
					</div>
					<div class="book_add">
						<button class="cart" bookId="${book.id}">加入购物车</button>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>

<%--		分页条--%>
		<%@include file="/pages/common/page_nav.jsp"%>
	</div>

     <%@include file="/pages/common/tail.jsp"%>
</body>
</html>