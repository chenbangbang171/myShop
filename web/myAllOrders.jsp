<%@ page import="com.czj.myShop.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="com.czj.myShop.entity.OrderDetail" %><%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/16
  Time: 19:18
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
        function confirm(e) {
            var re = $(e);
            $.ajax({
                url: "UpdateOrderServlet?method=confirm",
                data: {
                    "orderId": re.attr("orderId"),
                    "orderStatus": re.attr("orderStatus")
                },
                type: "post",
                dataType: "json",
                success: function (result) {
                    alert(result.msg);
                    location.href = "OrderServlet?method=queryCurrentOrders";
                },
                error: function (result) {
                    alert("确认收货失败了！");

                }
            });
        }
    </script>
    <title>我的当前订单</title>
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
</head>
<body>
<%
    String username = (String) request.getSession().getAttribute("username");
    String address_userphone = (String) request.getAttribute("address_userphone");
    String address_detail = (String) request.getAttribute("address_detail");

%>
<table>
    <tr id="tr1">
        <th>订单编号</th>
        <th>用户名</th>
        <th>商品单价</th>
        <th>订单总价</th>
        <th>订单状态</th>
        <th>订单时间</th>
        <th>收件人地址</th>
        <th>收件人电话</th>
    </tr>

    <%
        List<OrderDetail> orderList = (List<OrderDetail>) request.getAttribute("orderDetails");
        String status = "";
        for (OrderDetail order : orderList) {
            //订单状态：0未支付、1支付成功，等待发货、2已发货，运输中、3已到达，等待领取、4待确认收货、5待评价
            if (order.getOrder_status() == 0) {
                status = "未支付";
            } else if (order.getOrder_status() == 1) {
                status = "支付成功，等待发货";
            } else if (order.getOrder_status() == 2) {
                status = "已发货，运输中";
            } else if (order.getOrder_status() == 3) {
                status = "已到达，等待领取";
            } else if (order.getOrder_status() == 4) {
                status = "已领取，待确认收货";
            } else if (order.getOrder_status() == 5) {
                status = "待评价";
            }else {
                status = "交易完成";

            }

    %>
    <tr id="tr1">
        <th>
            <%=order.getOrder_id()%>
        </th>
        <th>
            <%=order.getOrder_userName()%>
        </th>
        <th>
            <%=order.getOrder_goodsPrice()%>
        </th>
        <th>
            <%=order.getOrder_price()%>
        </th>
        <th>
            <%=status%>
        </th>
        <th>
            <%=order.getOrder_time()%>
        </th>
        <th>
            <%=order.getOrder_address()%>
        </th>
        <th>
            <%=order.getOrder_phoneNumber()%>
        </th>
    </tr>
    <%

        }
    %>
</table>
<button><a href="GoodsServlet?method=qureyAllGoods">返回首页</a></button>
</body>
</html>
