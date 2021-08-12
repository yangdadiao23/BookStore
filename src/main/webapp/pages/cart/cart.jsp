<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/pages/common/head.jsp"%>
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript">
		$(function (){
			$("a.deleteItem").click(function (){
				return confirm("确定删除《"+$(this).parent().parent().find("td:first").text()+"》?");
			})

			$("a.clearItem").click(function (){
				return  confirm("确定清空购物车吗?");
			})

			$(".updateItem").change(function () {
			var newCount=this.value;
			var id = $(this).attr("bookId");
/*				return confirm("确定修改《"+$(this).parent().parent().find("td:first").text()+"》数量为"+newCount+"?")*/
				 if(confirm("确定修改《"+$(this).parent().parent().find("td:first").text()+"》数量为"+newCount+"?")){
				 	location.href="http://localhost:8080/BookStore/cartServlet?action=updateItem&id="+id+"&count="+newCount;
				 }else{
				 	this.value=this.defaultValue;
				 	return false;
				 }
			})



		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
             <%@include file="/pages/common/menu.jsp"%>
	</div>
	
	<div id="main">
	
		<table>

			<c:if test="${ not empty sessionScope.cart.items}">
				<tr>
					<td>商品名称</td>
					<td>数量</td>
					<td>单价</td>
					<td>金额</td>
					<td>操作</td>
				</tr>
			</c:if>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5"><a href="index.jsp">购物车为空，快去逛逛吧！</a></td>
				</tr>
			</c:if>


			<c:if test="${not empty sessionScope.cart.items}">
           <c:forEach items="${sessionScope.cart.items}" var="item">
			   <tr>
				   <td>${item.value.name}</td>
				   <td>
						 <input bookId="${item.value.id}" class="updateItem" type="text"style="width: 40px" value="${item.value.count}"/>
				   </td>
				   <td>${item.value.price}</td>
				   <td>${item.value.totalPrice}</td>
				   <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${item.value.id}">删除</a></td>
			   </tr>
		   </c:forEach>
			</c:if>
		</table>

		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a class="clearItem"  href="cartServlet?action=clearItem">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>

	
	</div>
	
     <%@include file="/pages/common/tail.jsp"%>
</body>
</html>