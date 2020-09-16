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
        <th id="">订单编号</th>
        <th id=""><%=orderInfo.getOrder_id()%></th>
    </tr>
    <tr>
        <th id="">用户名</th>
        <th id=""><%=username%></th>
    </tr>
    <tr>
        <th id="">商品单价</th>
        <th id=""><%=orderInfo.getOrder_goodsprice()%></th>
    </tr>
    <tr>
        <th id="">订单总价</th>
        <th id=""><%=orderInfo.getOrder_price()%></th>
    </tr>
    <tr>
        <th id="">订单状态</th>
        <th id="">未支付</th>
    </tr>
    <tr>
        <th id="">订单时间</th>
        <th id=""><%=orderInfo.getOrder_time()%></th>
    </tr>
    <tr>
        <th id="">收件人地址</th>
        <th id=""><%=address_detail%></th>
    </tr>
    <tr>
        <th id="">收件人电话</th>
        <th id=""><%=address_userphone%></th>
    </tr>

</table>

<h3><a href="">点我支付！！！！</a></h3>
</body>
</html>
