<%@ page import="com.czj.myShop.entity.Goods" %><%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/14
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品信息</title>
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
    //获取request域中的数据
    Goods goods = (Goods) request.getAttribute("goodsInfo");

%>

<form action="GoodsServlet?method=updateGoodsById" method="post">
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
            <th><input type="text" value="<%=goods.getGoods_id() %>" readonly="readonly" name="goods_id"></th>
            <th><input type="text" value="<%=goods.getGoods_name() %>" name="goods_name"></th>
            <th><input type="text" value="<%=goods.getGoods_date() %>" name="goods_date"></th>
            <th><input type="text" value="<%=goods.getGoods_picture()%>" name="goods_picture"></th>
            <th><input type="text" value="<%=goods.getGoods_price() %>" name="goods_price"></th>
            <th><input type="text" value="<%=goods.getGoods_star()%>" name="goods_star"></th>
            <th><input type="text" value="<%=goods.getGoods_info() %>" name="goods_info"></th>
            <th><input type="text" value="<%=goods.getGoods_typeid() %>" name="goods_typeid"></th>
            <th><input type="submit" value="修改"></th>
        </tr>
    </table>
</form>
</body>
</html>
