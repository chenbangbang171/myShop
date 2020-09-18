<%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/14
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        table {
            width: 800px;
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
    <title>管理总页</title>
</head>
<body>

<a href="GoodsServlet?method=qureyAllGoods">查看所有商品</a>
<a href="addGoods.jsp">添加商品</a>
<a href="UserServlet?method=queryAllUsers">查看所有用户</a>
<a href="addUser.jsp">添加用户</a>
<a href="OrderServlet?method=queryAllOrdersForManager">查看所有订单</a>
</body>
</html>
