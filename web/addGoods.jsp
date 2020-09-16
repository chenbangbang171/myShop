<%@ page import="com.czj.myShop.entity.Goods" %><%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/14
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
    <style type="text/css">
        form {
            width: 800px;
            border: 0px solid black;
            height: 1000px;
        }

        tr1 {
            border-bottom: 1px solid black;
        }

        th {
            width: 80px;
            border: 1px solid black;
        }
    </style>
</head>
<body>

<form action="GoodsServlet?method=addGoods" method="post">
    商品名称:<input type="text"  name="goods_name"><br/>
    商品日期:<input type="text"  name="goods_date"><br/>
    商品图片:<input type="text" name="goods_picture"><br/>
    商品价格:<input type="text"  name="goods_price"><br/>
    商品信息:<input type="text" name="goods_info"><br/>
    商品类型:<input type="text" name="goods_typeid"><br/>
    <input type="submit" value="添加">
</form>
</body>
</html>
