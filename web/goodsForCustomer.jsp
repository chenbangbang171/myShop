<%@ page import="com.czj.myShop.entity.Goods" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/14
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="jquery-3.3.1.js"></script>
    <script type="text/javascript">
        <%--  $(document).ready(function () {//为收藏功能保留--%>
        <%--    $("#add").on("click", function () {--%>
        <%--        var $goodsNumber = $("#goodsNumber").val();--%>
        <%--        $.post(--%>
        <%--            "CartServlet?method=addGoodsToCart",--%>
        <%--            {--%>
        <%--                "goodsId":<%=goods.getGoods_id()%>,--%>
        <%--                "goodsPrice":<%=goods.getGoods_price()%>,--%>
        <%--                "goodsNumber": 1,--%>
        <%--            },--%>
        <%--            function (result) {--%>
        <%--                var result = eval(result);--%>
        <%--                alert(result.msg1 +"1个" + "<%=goods.getGoods_name()%>" + result.msg2);--%>
        <%--            }, "json"--%>
        <%--        );--%>

        <%--    });--%>
        <%--});--%>
        $(document).ready(function () {
            $("#searching").on("click", function () {
                var $goodsId = $("#goods_id").val();
                $.post(
                    "GoodsServlet?method=qureyGoodsByIdForSearching",
                    {
                        "goodsId": $goodsId
                    },
                    function (result) {
                        var goods = eval(result.goods);

                        $("#goods_name").html(goods.goods_name);
                        $("#goods_date").html(goods.goods_date);
                        //将图片列的src替换成该商品的图片字段值，用于显示
                        var goodsPic = document.getElementById("goods_pic");
                        goodsPic.setAttribute("src", goods.goods_picture);

                        $("#goods_price").html(goods.goods_price);
                        $("#goods_star").html(goods.goods_star);
                        $("#goods_info").html(goods.goods_info);
                        $("#goods_type").html(goods.goods_star);

                        //将首列变成连接，点进去进入商品详情页
                        var goodsName = document.getElementById("goods_name");
                        goodsName.setAttribute("href", "GoodsServlet?method=goodsDetail&goods_id=" + goods.goods_id);

                        //显示表格，不点击检索默认不显示
                        $("#searchingTable").attr("style", "display: ");

                    }, "json"
                );

            });

            $("#myCart").on("click", function () {
                $.post(
                    "CartServlet?method=getMyCart",
                    {},
                    function (result) {
                        var $cartTable = $("#cartTable");
                        var $flag = $("#cartTable").attr("flag");//购物车表格是否有内容标志，0为没有，1为有
                        var display = $cartTable[0].style.display;
                        if (display == 'none') {//若当前表格为隐藏
                            if ( $flag == 0){ //若表格没有内容，则添加内容并显示
                                var myCart = eval(result.showCart);
                                $.each(myCart, function (i, value) {
                                    $cartTable.append("<tr>" +
                                        "<th>" + '<a href="GoodsServlet?method=goodsDetail&goods_id=' + value.goodsId + '">' + value.goodsName + '</a>' + "</th>" +
                                        "<th>" + '<img src="' + value.goodsPicture + '" width="100px" higth="100px" />' + "</th>" +
                                        "<th>" + value.goodsPrice + "</th>" +
                                        "<th id='" + value.goodsId + "'>" + value.goodsNumber + "</th>" +
                                        "<th>" + value.totalPrice + "</th>" +
                                        "</tr>");
                                });
                                $cartTable.attr("style", "display:");//显示
                            }else{//表格有内容但是处于隐藏状态
                                $cartTable.attr("style", "display:");//显示，不在添加内容
                            }
                        }
                    }, "json"
                );
            });

            $("#hideTheSearching").on("click", function () {
                $("#searchingTable").attr("style", "display:none");
            });

            $("#hideMyCart").on("click", function () {
                $("#cartTable").attr("style", "display:none");//隐藏表格
                $("#cartTable").attr("flag", "1");//把内容标志位设为1，

            });




        });
    </script>
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
        a{
            text-decoration: none;
        }
        a:visited {
            text-decoration: none;
        }
        a:active {
            text-decoration: none;
        }
    </style>
    <title>Title</title>
</head>
<body>
<%
    String username = (String) session.getAttribute("username");
    if (null == username) {
%>
<a href="regist.jsp">点我注册哦亲！~</a>
<%
} else {
%>
<%=username%>宝贝您来啦？！！
<%
    }
%>

<button>
    <a href="UserServlet?method=logout&username=<%=username%>">点我注销哦亲爱的&nbsp;<%=username%></a>
</button>
<br>
<!--输入商品id进行检索-->
检索商品:<input type="text" placeholder="请输入商品编号..." name="goods_id" id="goods_id">
<button id="searching">检索</button>
<button id="hideTheSearching">收起检索</button>
<br>
<!--检索商品列表，该列表默认不出现，点击检索按钮显示，-->
<table style="display:none" id="searchingTable">
    <tr id="tr1">
        <th>商品名称</th>
        <th>商品日期</th>
        <th>商品图片</th>
        <th>商品价格</th>
        <th>商品评分</th>
        <th>商品信息</th>
        <th>操作</th>
        <th>隐藏</th>
    </tr>
    <tr id="tr1">
        <th><a href="" id="goods_name"></a></th>
        <th id="goods_date"></th>
        <th><img src="" width="100px" height="100px" id="goods_pic"></th>
        <th id="goods_price"></th>
        <th id="goods_star"></th>
        <th id="goods_info"></th>
        <th><a href="" id="">收藏</a></th>
    </tr>
</table>
&nbsp;<br>


<!--购物车按钮-->
<button id="myCart">我的购物车</button>
<button id="hideMyCart">收起购物车</button>
<button id="manageMyCart"><a href="CartServlet?method=manageMyCart">管理我的购物车</a></button>
<button id="myOrders"><a href="OrderServlet?method=queryCurrentOrders">我的订单</a></button>
<button id="myOrders"><a href="OrderServlet?method=queryAllOrders">我的全部订单</a></button>
<!--购物车，该列表默认不出现，点击我的购物车按钮显示，-->
<table style="display:none" id="cartTable" flag="0">
    <tr id="tr1">
        <th>商品名称</th>
        <th>商品图片</th>
        <th>商品单价</th>
        <th>商品数量</th>
        <th>商品总价格</th>
    </tr>
</table>
&nbsp;<br>


<!--主要的商品区域-->
<table>
    <tr id="tr1">
        <th>商品名称</th>
        <th>商品日期</th>
        <th>商品图片</th>
        <th>商品价格</th>
        <th>商品评分</th>
        <th>商品信息</th>
        <th>操作</th>
    </tr>
    <%
        //获取request域中的数据
        List<Goods> goodsList = (List<Goods>) request.getAttribute("goodsList");
        for (Goods goods : goodsList) {//遍历商品集合
    %>

    <tr id="tr1">
        <th><a href="GoodsServlet?method=goodsDetail&goods_id=<%=goods.getGoods_id()%>"><%=goods.getGoods_name() %>
        </a></th>
        <th><%=goods.getGoods_date() %>
        </th>
        <th><img src="<%=goods.getGoods_picture()%>" width="100px" height="100px" id="goods_pic"></th>
        <th><%=goods.getGoods_price() %>
        </th>
        <th><%=goods.getGoods_star()%>
        </th>
        <th><%=goods.getGoods_info() %>
        </th>
        <%--        <th><a href="CartServlet?method=addGoodsToCart&goodsId=<%=goods.getGoods_id()%>&goodsPrice=<%=goods.getGoods_price()%>&goodsNumber=1">添加到购物车</a></th>--%>
        <th>
            <button><a href="CartServlet?method=">收藏</a></button>
            <button><a>加入到购物车</a></button>
        </th>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
