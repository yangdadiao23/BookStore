<%@ page import="Variety.utils.ToolsUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="Variety.pojo.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
             <%@include file="/pages/common/menu.jsp"%>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>

			<c:if test="${empty sessionScope.orders}">
				<tr>
					<td colspan="4">订单为空，快去购物吧！</td>
				</tr>
			</c:if>
			<c:if test="${not empty sessionScope.orders}">
				<% List<Order>orders=(List<Order>) request.getSession().getAttribute("orders");
					int[] status=new int[orders.size()];
					int i=0;
					for(Order o:orders){
                          status[i++]=o.getStatus();
					}
					i=0;
				%>
				<c:forEach items="${sessionScope.orders}" var="order">
					<tr>
						<td>${order.create_time}</td>
						<td>${order.price}</td>
						<td><%=ToolsUtils.intToStatus(status[i++])%></td>
						<td><a href="orderServlet?action=searchOrder&order_id=${order.order_id}">查看详情</a></td>
					</tr>
				</c:forEach>


			</c:if>



		</table>
		
	
	</div>
     <%@include file="/pages/common/tail.jsp"%>
</body>
</html>