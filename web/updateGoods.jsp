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
<%
    //获取request域中的数据
    Goods goods = (Goods) request.getAttribute("goodsInfo");

%>
<form action="GoodsServlet?method=updateGoodsById" method="post">
    商品id :<input type="text" value="<%=goods.getGoods_id() %>" readonly="readonly" name="goods_id"><br/>
    商品名称:<input type="text" value="<%=goods.getGoods_name() %>" name="goods_name"><br/>
    商品日期:<input type="text" value="<%=goods.getGoods_date() %>" name="goods_date"><br/>
    商品图片:<input type="text" value="<%=goods.getGoods_picture()%>" name="goods_picture"><br/>
    商品价格:<input type="text" value="<%=goods.getGoods_price() %>" name="goods_price"><br/>
    商品评分:<input type="text" value="<%=goods.getGoods_star()%>" name="goods_star"><br/>
    商品信息:<input type="text" value="<%=goods.getGoods_info() %>" name="goods_info"><br/>
    商品类型:<input type="text" value="<%=goods.getGoods_typeid() %>" name="goods_typeid"><br/>
    <input type="submit" value="修改">
</form>
</body>
</html>
