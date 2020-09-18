<%@ page import="com.czj.myShop.entity.Goods" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/14
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看商品</title>
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
<script type="text/javascript" src="jquery-3.3.1.js">
    function queryGoods(){
        var $goodsid =  $(#goods_id).val;
        $.post(
            "GoodsServlet?method=qureyGoodsById",
            "goods_id="+$goodsid,
            function(obj){

        });
    }
</script>
</head>
<body>

检索商品:<input type="text" placeholder="请输入商品编号..." name="goods_id" id="goods_id">
<button  onclick="queryGoods()">检索</button><br>

<table>
    <tr id="tr1">
        <th>商品id</th>
        <th>商品名称</th>
        <th>商品日期</th>
        <th>商品图片</th>
        <th>商品价格</th>
        <th>商品评分</th>
        <th>商品信息</th>
        <th>商品类型</th>
        <th>操作</th>
    </tr>

    <%
        //获取request域中的数据
        List<Goods> goodsList = (List<Goods>)request.getAttribute("goodsList");
        for(Goods goods:goodsList){//遍历商品集合
    %>
    <tr id="tr1">
        <th><a href="GoodsServlet?method=qureyGoodsById&goods_id=<%=goods.getGoods_id()%>"><%=goods.getGoods_id()%></a></th>
        <th><%=goods.getGoods_name() %></th>
        <th><%=goods.getGoods_date() %></th>
        <th><%=goods.getGoods_picture()%></th>
        <th><%=goods.getGoods_price() %></th>
        <th><%=goods.getGoods_star()%></th>
        <th><%=goods.getGoods_info() %></th>
        <th><%=goods.getGoods_typeid() %></th>
        <th><a href="GoodsServlet?method=deleteGoodsById&goods_id=<%=goods.getGoods_id()%>">删除</a></th>
    </tr>
    <%
        }
    %>

</table>
<button><a href="manage.jsp">返回首页</a></button>
</body>
</html>
