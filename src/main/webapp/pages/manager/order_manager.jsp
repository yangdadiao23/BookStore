<%@ page import="Variety.pojo.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="Variety.utils.ToolsUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
      <%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
			</tr>
			<% List<Order> orders=(List<Order>) request.getSession().getAttribute("orders");
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
				<td><a href="">查看详情</a></td>
				<td><a href=""><%=ToolsUtils.intToStatus(status[i++])%></a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
     <%@include file="/pages/common/tail.jsp"%>
</body>
</html>