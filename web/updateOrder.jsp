<%@ page import="com.czj.myShop.entity.OrderDetail" %><%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/17
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
    <title>编辑订单</title>
</head>
<body>
<%
    //获取request域中的数据
    OrderDetail orderDetail = (OrderDetail) request.getAttribute("orderDetail");

%>

<form action="OrderServlet?method=updateOrderById" method="post">
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
            <th>修改</th>
        </tr>
        <tr>
            <th><input type="text" value="<%=orderDetail.getOrder_id()%>" readonly name="order_id"></th>
            <th><input type="text" value="<%=orderDetail.getOrder_userName() %>"  readonly name="order_userName"></th>
            <th><input type="text" value="<%=orderDetail.getOrder_goodsPrice() %>" readonly name="order_goodsPrice"></th>
            <th><input type="text" value="<%=orderDetail.getOrder_price()%>" readonly name="order_price"></th>
            <th><input type="text" value="<%=orderDetail.getOrder_status() %>" name="order_status"></th>
            <th><input type="text" value="<%=orderDetail.getOrder_time()%>" name="order_time" readonly></th>
            <th><input type="text" value="<%=orderDetail.getOrder_address() %>" name="order_address"></th>
            <th><input type="text" value="<%=orderDetail.getOrder_phoneNumber() %>" name="order_phoneNumber"></th>
            <th>
                <input type="submit" value="提交">
            </th>
        </tr>
    </table>
</form>
<button><a href="manage.jsp">返回首页</a></button>
</body>
</html>
