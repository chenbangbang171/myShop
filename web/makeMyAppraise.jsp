<%@ page import="com.czj.myShop.entity.Appraise" %><%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/17
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        Appraise appraise = (Appraise)request.getAttribute("appraise");
        int goods_price = (int)request.getAttribute("goods_price");
    %>
    <script type="text/javascript" src="jquery-3.3.1.js"></script>
    <script type="text/javascript">
        function submitMyAppraise() {
            var $star = $("#star").val();
            var $appraise = $("#appraise").val();
            $.ajax({
                url:"UpdateOrderServlet?method=makeMyAppraise",
                data:{
                    "star":$star,
                    "appraise":$appraise,
                    "orderId":<%=appraise.getOrderId()%>
                },
                type:"post",
                dataType:"json",
                success:function (result) {
                    alert(result.msg);
                    location.href = "OrderServlet?method=queryCurrentOrders";
                },
                error:function (result) {

                }
            });

        }

    </script>
    <title>写评价</title>
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
    <tr>
        <th colspan="2"><h2>请写下您对<%=appraise.getGoodsName()%>的评价:</h2></th>
    </tr>
    <tr>
        <th>商品名</th>
        <th><%=appraise.getGoodsName()%></th>
    </tr>
    <tr>
        <th>商品图片</th>
        <th><img src="<%=appraise.getGoodsPic()%>" width="200px" height="200px"></th>
    </tr>
    <tr>
        <th>商品价格</th>
        <th><%=goods_price%></th>
    </tr>
    <tr>
        <th>评分</th>
        <th><input type="text" placeholder="请输入0~10的数字进行打分...." id="star"></th>
    </tr>
    <tr>
        <th>评价：</th>
        <th><textarea cols="5" rows="5" placeholder="请输入评价" id="appraise"></textarea></th>
    </tr>
    <tr>
        <th>提交</th>
        <th><button><a href="javaScript:submitMyAppraise();">提交</a></button></th>
    </tr>
</table>
</body>
</html>
