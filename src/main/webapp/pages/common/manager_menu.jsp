<%--
  Created by IntelliJ IDEA.
  User: 15498
  Date: 2021/8/1
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<div>
    <c:if test="${empty requestScope.page.url}">
        <a href="manager/bookServlet?action=page">图书管理</a>
    </c:if>
   <c:if test="${not empty requestScope.page.url}">
       <a href="${requestScope.page.url}">图书管理</a>
   </c:if>
    <a href="managerServlet?action=showOrder">订单管理</a>
    <a href="index.jsp">返回商城</a>
</div>
</body>
</html>
