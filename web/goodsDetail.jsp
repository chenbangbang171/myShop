<%@ page import="com.czj.myShop.entity.Goods" %><%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/14
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    Goods goods = (Goods) request.getAttribute("goodsInfo");
%>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery-3.3.1.js"></script>

</head>
<body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#add").on("click", function () {
            var $goodsNumber = $("#goodsNumber").val();
            $.post(
                "CartServlet?method=addGoodsToCart",
                {
                    "goodsId":<%=goods.getGoods_id()%>,
                    "goodsPrice":<%=goods.getGoods_price()%>,
                    "goodsNumber": $goodsNumber,
                },
                function (result) {
                    var result = eval(result);
                    alert(result.msg1 + result.goodsNumber + "个" + "<%=goods.getGoods_name()%>" + result.msg2);
                }, "json"
            );

        });
    });
</script>
<div>
    <img src="<%=goods.getGoods_picture()%>" width="500px" height="500px">
    <h1><%=goods.getGoods_name()%>你值得拥有！</h1>
    <h1>惊爆价只要<%=goods.getGoods_price()%>元！！！只要<%=goods.getGoods_price()%>元！！！！</h1>
    <div style="font-size: 30px">点击右侧按钮加入购物车！！！</div>
    <input type="text" id="goodsNumber" oninput="value=value.replace(/[^\d]/g,'')">
    <input type="button" id="add" value="添加到购物车">
    <button><a href="GoodsServlet?method=qureyAllGoods">返回首页</a></button>
</div>
</body>
</html>
