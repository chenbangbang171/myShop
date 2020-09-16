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
            }
            if (order.getOrder_status() != 6) {
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
        <%
            if (order.getOrder_status() == 0) {
        %>
        <th>
            <%=status%>
            <button><a href="UpdateOrderServlet?method=pay&orderId=<%=order.getOrder_id()%>">点我支付</a></button>
        </th>
        <%
        } else if (order.getOrder_status() == 4) {
        %>
        <th>
            <%=status%>
            <button><a href="UpdateOrderServlet?method=confirm&orderId=<%=order.getOrder_id()%>">点我确认收货</a></button>
        </th>
        <%
        } else if (order.getOrder_status() == 5) {
        %>
        <th>
            <%=status%>
            <button><a href="UpdateOrderServlet?method=appraise&orderId=<%=order.getOrder_id()%>">点我评价</a></button>
        </th>
        <%
        } else {
        %>
        <th>
            <%=status%>
        </th>
        <%
            }
        %>

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
        }
    %>
</table>
</body>
</html>
