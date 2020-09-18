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
    String username = (String) session.getAttribute("username");
    if (null == username) {
%>
<a href="regist.jsp">点我注册哦亲！~</a>
<%
} else {
%>
<%= username%>,要买小米儿不？
<%
    }
%>


<a href="GoodsServlet?method=qureyAllGoods">商品</a>

<a href="UserServlet?method=logout&username=<%=username%>">注销</a>
</body>
</html>
