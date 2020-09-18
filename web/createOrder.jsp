<%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/17
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>填写订单信息</title>
    <%
        int goodsId = (int) request.getAttribute("goodsId");
        int goodsNumber = (int)request.getAttribute("goodsNumber");
    %>
    <script type="text/javascript" src="jquery-3.3.1.js"></script>
    <script type="text/javascript">
        function makeOrder() {
            var $address = $("#addres").val();
            var $addressName = $("#addressName").val();
            var $addressPhone = $("#addressPhone").val();
            $.ajax({
                url: "OrderServlet?method=createNewOrder",
                data: {
                    "address": $address,
                    "addressName": $addressName,
                    "addressPhone": $addressPhone,
                    "goodsId":<%=goodsId%>,
                    "goodsNumber":<%=goodsNumber%>
                },
                type: "post",
                dataType: "json",
                success: function (result) {
                    var order = eval(result.order);
                    alert("下单成功！点击确定查看订单详情");
                    location.href = "OrderServlet?method=orderDetail&orderId=" + order.order_id;

                },
                error: function (result) {
                    alert("下单失败了！");

                }
            });
        }

        function getMyAddress() {

        }
    </script>
</head>
<body>
<button><a href="" onclick="javaScript:getMyAddress();">获取我的收件地址</a></button>
<table>
    <tr>
        <th>收件人姓名</th>
        <th><input type="text" id="addressName"></th>
    </tr>
    <tr>
        <th>收货电话</th>
        <th><input type="text" id="addressPhone"></th>
    </tr>
    <tr>
        <th>收货地址</th>
        <th><input type="text" id="addrss"></th>
    </tr>
    <tr>
        <th><input type="submit" value="下单" onclick="makeOrder()"></th>
    </tr>
</table>

</body>
</html>
