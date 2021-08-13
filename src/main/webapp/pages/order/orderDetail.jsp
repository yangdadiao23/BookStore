<%--
  Created by IntelliJ IDEA.
  User: 15498
  Date: 2021/8/13
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单详情</title>
  <%@include file="/pages/common/head.jsp"%>
</head>
<body>
         <div id="main">
           <table>
             <tr>
               <td>订单号</td>
               <td>商品名称</td>
               <td>数量</td>
               <td>单价</td>
               <td>金额</td>
             </tr>
               <c:forEach items="${sessionScope.orderItems}" var="item">
               <tr>
                   <td>${sessionScope.order_id}</td>
                   <td>${item.name}</td>
                   <td>${item.count}</td>
                   <td>${item.price}</td>
                   <td>${item.total_price}</td>
               </tr>
               </c:forEach>
               <div><a href="pages/order/order.jsp">返回订单</a></div>
           </table>
         </div>
</body>
</html>
