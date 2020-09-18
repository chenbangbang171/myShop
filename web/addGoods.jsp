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

        table{
            width: 800px;
            border: 1px solid black;
            height: 50px;
        }
        #tr1{
            border-bottom: 1px solid black;
        }
        th{
            width: 80px;
            border: 1px solid black;
        }
    </style>
</head>
<body>

<form action="GoodsServlet?method=addGoods" method="post">
    <table>
        <tr>
            <th>商品id :</th>
            <th>商品名称</th>
            <th>商品日期</th>
            <th>商品图片</th>
            <th>商品价格</th>
            <th>商品评分</th>
            <th>商品信息</th>
            <th>商品类型</th>
            <th>提交</th>
        </tr>
        <tr>
            <th><input type="text"  name="goods_id" placeholder="请输入商品id"></th>
            <th><input type="text" name="goods_name" placeholder="请输入商品名称"></th>
            <th><input type="text"  name="goods_date" placeholder="请输入商品日期"></th>
            <th><input type="text"  name="goods_picture" placeholder="请输入商品图片"></th>
            <th><input type="text" name="goods_price" placeholder="请输入商品价格"></th>
            <th><input type="text" name="goods_star" placeholder="请输入商品评分"></th>
            <th><input type="text"  name="goods_info" placeholder="请输入商品信息"></th>
            <th><input type="text"  name="goods_typeid" placeholder="请输入商品类型"></th>
            <th>
                <input type="submit" value="提交">
            </th>
        </tr>
    </table>
</form>
</body>
</html>
