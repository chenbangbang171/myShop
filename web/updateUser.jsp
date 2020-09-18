<%@ page import="com.czj.myShop.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/17
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
    <style type="text/css">
        table {
            width: 1100px;
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

        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
%>
<form action="UserServlet?method=updateUser" method="post">
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
            <th>提交</th>
        </tr>
        <tr>
            <th><input type="text" value="<%=user.getId()%>" readonly name="id"></th>
            <th><input type="text" value="<%=user.getUsername()%>" name="username"></th>
            <th><input type="text" value="<%=user.getPassword()%>" name="password"></th>
            <th><input type="text" value="<%=user.getEmail()%>" readonly name="email"></th>
            <th><input type="text" value="<%=user.getGender()%>" name="gender"></th>
            <th><input type="text" value="<%=user.getFlag()%>" name="flag"></th>
            <th><input type="text" value="<%=user.getRole()%>" name="role"></th>
            <th><input type="text" value="<%=user.getCode()%>" readonly name="code"></th>
            <th>
<%--                <button><a href="UserServlet?method=queryAllUsers">提交</a></button>--%>
                <input type="submit" value="提交">
            </th>
        </tr>
    </table>
</form>
</body>
</html>
