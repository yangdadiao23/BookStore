<%--
  Created by IntelliJ IDEA.
  User: 15498
  Date: 2021/8/1
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <%
       String address=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    %>
    <%--<%=address%>--%>
<%--    <base href="http://localhost:8080/BookStore/">--%>
    <base href=<%=address%>>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >

