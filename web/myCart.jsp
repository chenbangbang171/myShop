<%@ page import="com.czj.myShop.entity.ShowCart" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/15
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="jquery-3.3.1.js"></script>
    <script type="text/javascript">
        function createOrder(e) {
                var re = $(e);
            $.ajax({
                url: "OrderServlet?method=createOrder",
                data: {
                    "goodsId": re.attr("goodsId"),
                    "goodsPrice": re.attr("goodsPrice"),
                    "goodsNumber": re.attr("goodsNumber"),
                    "totalPrice": re.attr("totalPrice")
                },
                type: "post",
                dataType: "json",
                success: function (result) {
                    var order = eval(result.order);
                    alert("下单成功！点击确定查看订单详情");
                    location.href = "OrderServlet?method=orderDetail&orderId="+order.order_id;

                },
                error: function (result) {
                    alert("下单失败了！");

                }
            });
        }
    </script>
    <title>我的无敌购物车</title>
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
        #back{
            float: left;
        }
    </style>
</head>

<body>
<table>
    <tr id="tr1">
        <th>商品编码</th>
        <th>商品名称</th>
        <th>商品图片</th>
        <th>商品单价</th>
        <th>商品数量</th>
        <th>商品总价格</th>
        <th>修改数量</th>
        <th>下单</th>
    </tr>
    <%
        String username = (String)request.getSession().getAttribute("username");
        List<ShowCart> allCarts = (List<ShowCart>) request.getAttribute("allCarts");
        for (ShowCart cart : allCarts) {//遍历商品集合
    %>
    <tr id="tr1">
        <th id="goodsId">
            <%= cart.getGoodsId()%>
        </th>
        <th>
            <%= cart.getGoodsName()%>
        </th>
        <th>
            <img src="<%= cart.getGoodsPicture()%>" width="100px" height="100px" id="goods_pic"></th>
        <th id="goodsPrice">
            <%= cart.getGoodsPrice()%>
        </th>
        <th id="goodsNumber">
            <%= cart.getGoodsNumber()%>
        </th>
        <th id="totalPrice">
            <%= cart.getTotalPrice()%>
        </th>
        <th>
            <button>
                <a href="CartServlet?method=goodsNumberUp&goodsId=<%=cart.getGoodsId()%>&goodsPrice=<%=cart.getGoodsPrice()%>&goodsNumber=<%=cart.getGoodsNumber()%>&totalPrice=<%=cart.getTotalPrice()%>">
                    加一个
                </a>
            </button>
            <button>
                <a href="CartServlet?method=goodsNumberDown&goodsId=<%=cart.getGoodsId()%>&goodsPrice=<%=cart.getGoodsPrice()%>&goodsNumber=<%=cart.getGoodsNumber()%>&totalPrice=<%=cart.getTotalPrice()%>">
                    减一个
                </a>
            </button>
        </th>
        <th>
            <button>
                <a onclick="createOrder(this)" goodsId="<%=cart.getGoodsId()%>" goodsPrice="<%=cart.getGoodsPrice()%>" goodsNumber="<%=cart.getGoodsNumber()%>" totalPrice="<%=cart.getTotalPrice()%>">点击下单</a>
            </button>
<%--            <button>--%>
<%--                <a href="OrderServlet?method=createNewOrder&goodsId="<%=cart.getGoodsId()%>>点击下单</a>--%>
<%--            </button>--%>
<%--            <button>--%>
<%--                <a href="createOrder.jsp?goodsId=<%=cart.getGoodsId()%>&goodsNumber= <%=cart.getGoodsNumber()%>">点击下单</a>--%>
<%--            </button>--%>
        </th>
    </tr>

    <%
        }
    %>

    <button>
        <a href="UserServlet?method=logout&username=<%=username%>">点我注销哦亲爱的&nbsp;<%=username%></a>
    </button><br>
    <button id="back"><a href="GoodsServlet?method=qureyAllGoods">返回首页</a></button>
    <button><a href="CartServlet?method=clearCart">清空购物车</a></button>
</table>
</body>
</html>
