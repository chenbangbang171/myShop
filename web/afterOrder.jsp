<%@ page import="com.czj.myShop.entity.Order" %><%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/16
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="jquery-3.3.1.js"></script>
    <script type="text/javascript">
        function pay(e) {
            var re = $(e);
            $.ajax({
                url: "UpdateOrderServlet?method=pay",
                data: {
                    "orderId": re.attr("orderId"),
                    "orderStatus": re.attr("orderStatus")
                },
                type: "post",
                dataType: "json",
                success: function (result) {

                    //var msg = eval(result.msg);
                    alert(result.msg);
                    location.href = "OrderServlet?method=queryCurrentOrders";

                },
                error: function (result) {
                    alert("支付失败了！");

                }
            });
        }
    </script>
    <title>Title</title>
    <style type="text/css">
        table {
            width: 400px;
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
<%
    String username = (String)request.getSession().getAttribute("username");
    String address_userphone = (String)request.getAttribute("address_userphone");
    String address_detail = (String)request.getAttribute("address_detail");
    Order orderInfo = (Order)request.getAttribute("orderInfo");

%>
<h1>下单成功，请尽快支付！</h1><br>
<h2>订单信息：</h2><br>
<table>
    <tr>
        <th>订单编号</th>
        <th><%=orderInfo.getOrder_id()%></th>
    </tr>
    <tr>
        <th>用户名</th>
        <th><%=username%></th>
    </tr>
    <tr>
        <th>商品单价</th>
        <th><%=orderInfo.getOrder_goodsprice()%></th>
    </tr>
    <tr>
        <th>订单总价</th>
        <th><%=orderInfo.getOrder_price()%></th>
    </tr>
    <tr>
        <th>订单状态</th>
        <th>未支付</th>
    </tr>
    <tr>
        <th>订单时间</th>
        <th><%=orderInfo.getOrder_time()%></th>
    </tr>
    <tr>
        <th>收件人地址</th>
        <th><%=address_detail%></th>
    </tr>
    <tr>
        <th>收件人电话</th>
        <th><%=address_userphone%></th>
    </tr>

</table>

<h3><button><a onclick="pay(this)" orderId="<%=orderInfo.getOrder_id()%>" orderStatus="<%=orderInfo.getOrder_status()%>">点我支付！！！！</a></button></h3>
<button><a href="GoodsServlet?method=qureyAllGoods">暂不支付，回到首页</a></button>
</body>
</html>
