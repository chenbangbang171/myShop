<%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/11
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = (String)session.getAttribute("username");
%>
<%= username%>,要买小米儿不？
<a href="UserServlet?method=logout&username=<%=username%>">注销</a>
</body>
</html>
