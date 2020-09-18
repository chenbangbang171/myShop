<%@ page import="com.czj.myShop.entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/17
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有用户</title>
    <style type="text/css">
        table {
            width: 1200px;
            border: 1px solid black;
            height: 50px;
        }

        #tr1 {
            border-bottom: 1px solid black;
        }

        th {
            width: 80px;
            border: 1px solid black;
        }

        #back {
            float: left;
        }
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<%
    List<User> allUsers = (List<User>) request.getAttribute("allUsers");
%>
<table>
<tr>
    <th>用户id</th>
    <th>用户名</th>
    <th>用户密码</th>
    <th>用户邮箱</th>
    <th>用户性别</th>
    <th>用户状态</th>
    <th>用户角色</th>
    <th>激活码</th>
    <th>删除</th>
</tr>
    <%
        for (User user: allUsers) {
     %>
    <tr>
        <th><a href="UserServlet?method=queryUserById&userId=<%=user.getId()%>"><%=user.getId()%></a></th>
        <th><%=user.getUsername()%></th>
        <th><%=user.getPassword()%></th>
        <th><%=user.getEmail()%></th>
        <th><%=user.getGender()%></th>
        <th><%=user.getFlag()%></th>
        <th><%=user.getRole()%></th>
        <th><%=user.getCode()%></th>
        <th><button><a href="UserServlet?method=deleteUserById&userId=<%=user.getId()%>">删除</a></button></th>
    </tr>
     <%
        }
    %>
</table>
<button><a href="manage.jsp">返回首页</a></button>
</body>
</html>
