<%@ page import="com.czj.myShop.entity.Order" %><%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/16
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int userId = Integer.parseInt(request.getParameter("userId"));

%>
支付吧！！冲冲冲！！！<%=userId%>
</body>
</html>
