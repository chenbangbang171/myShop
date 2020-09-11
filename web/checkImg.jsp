<%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/8/28
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="jquery-3.3.1.js">
    </script>
    <script type="text/javascript">
        function reloadCheckImg(){
                //每次单击验证码图片，重新请求验证码；
                $("img").attr("src","checkCode.jsp?t="+(new Date().getTime()));
                //每次重新请求验证码之后，将span中的内容清空
                $("#tip").html("");
        }

        $(document).ready(function () {
            $("#checkCodeId").blur(function () {
                //获取用户输入的值
                var $checkCode = $("#checkCodeId").val();
                //ajax 的post请求
                $.post(
                    "CheckCodeServlet",//请求的地址
                    "checkCode="+$checkCode,//请求的数据
                    function (result) {
                        //获取到返回的result值
                        var resulthtml = $("<img src='" + result + "' height='15px' width='15px' />");

                        //每次请求后都将后面span标签中的内容填成返回的图片，对或者错
                        $("#tip").html(resulthtml);
                    }

                );

            });
        });
    </script>
</head>
<body>
验证码：
<input type="text" name="checkCode" size="4" id="checkCodeId">
<!--验证码-->
<a href="javascript:reloadCheckImg();"><img src="checkCode.jsp" /></a>
<span id="tip"></span>
</body>
</html>
