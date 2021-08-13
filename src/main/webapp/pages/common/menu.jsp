<%--
  Created by IntelliJ IDEA.
  User: 15498
  Date: 2021/8/1
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
 <div>
     <span>欢迎<span class="um_span">${sessionScope.username}</span>光临尚硅谷书城</span>
     <a href="orderServlet?action=showOrder">我的订单</a>
     <a href="userServlet?action=logout">注销</a>
     <a href="index.jsp">返回</a>
 </div>
</body>
</html>
