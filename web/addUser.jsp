<%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/17
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<form action="UserServlet?method=addUser" method="post">
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
            <th><input type="text"   name="id" placeholder="请输入用户id..."></th>
            <th><input type="text"  name="username" placeholder="请输入用户姓名..."></th>
            <th><input type="text"  name="password" placeholder="请输入用户密码..."></th>
            <th><input type="text"  name="email" placeholder="请输入用户邮箱..."></th>
            <th><input type="text" name="gender" placeholder="请输入用户性别..."></th>
            <th><input type="text"  name="flag" placeholder="请输入用户状态..."></th>
            <th><input type="text"  name="role" placeholder="请输入用户角色..."></th>
            <th><input type="text"  name="code" placeholder="请输入用户激活码..."></th>
            <th>  <input type="submit" value="提交"></th>
        </tr>
    </table>
</form>
</body>
</html>
