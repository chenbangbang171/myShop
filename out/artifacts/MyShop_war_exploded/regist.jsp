<%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/13
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript" src="jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#checkpassword").blur(function () {
                //获取用户输入的值
                var $checkpassword = $("#checkpassword").val();
                var $password = $("#password").val();

                if ($checkpassword != $password){
                    $("#checkpwd").html("两次输入不一致！");
                    $("#submit").attr("disabled", true);
                }else{
                    $("#checkpwd").html("");
                    $("#submit").attr("disabled", false);
                }
                //ajax 的post请求
                // $.post(
                //     "UserServlet?method=checkPassword",//请求的地址
                //     {"pwd1": $checkpassword, "pwd2": $password},//请求的数据
                //     function (result) {
                //         //将span内容填充
                //         $("#checkpwd").html(result);
                //         if (result != "") {
                //             $("#submit").attr("disabled", true);
                //         }
                //     }
                // );

            });

            $("#username").blur(function () {
                var $userName = $("#username").val();
                $.post(
                    "UserServlet?method=checkUserName",
                    {"userName": $userName},
                    function (result) {
                        $("#checkUserName").html(result);
                        if (result != ""){
                            $("#submit").attr("disabled", true);
                        }
                    }
                );

            });
        });

        function reloadCheckImg() {
            //每次单击验证码图片，重新请求验证码；
            $("img").attr("src", "checkCode.jsp?t=" + (new Date().getTime()));
            //每次重新请求验证码之后，将span中的内容清空
            $("#tip").html("");
        }

        $(document).ready(function () {
            $("#checkCodeId").blur(function () {
                //获取用户输入的值
                var $checkCode = $("#checkCodeId").val();
                //ajax 的post请求
                $.post(
                    "UserServlet?method=checkCode",//请求的地址
                    "checkCode=" + $checkCode,//请求的数据
                    function (result) {
                        //获取到返回的result值
                        var resulthtml = $("<img src='" + result + "' height='15px' width='15px' />");

                        //每次请求后都将后面span标签中的内容填成返回的图片，对或者错
                        $("#tip").html(resulthtml);
                        var check = result.substr(4, 5);
                        if (check == "right") {
                            $("#submit").attr("disabled", false);
                        } else {
                            $("#submit").attr("disabled", true);

                        }
                    }
                );

            });
        });

        $(document).ready(function () {
            $("#checkEmail").blur(function () {
                //获取用户输入的值
                var email = $("#checkEmail").val();
                //ajax 的post请求
                $.post(
                    "UserServlet?method=queryUserByEmail",//请求的地址
                    "checkEmail=" + email,//请求的数据
                    function (result) {
                        //将span内容填充
                        $("#checkem").html(result);
                        if (result != "") {
                            $("#submit").attr("disabled", true);
                        }
                    }
                );

            });
        });


    </script>
</head>
<body>
<form action="UserServlet?method=regist" method="post">
    <table width="500px" border="1px" align="center">

        <tr>
            <td style=" width: 120px">用户姓名</td>
            <td>
                <input type="text" name="username" id="username" placeholder="请输入用户名">
                <span id="checkUserName" style=" width: 40px"></span></td>

        </tr>
        <tr>
            <td>用户密码</td>
            <td><input type="password"  id="password" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td>再次输入密码</td>
            <td>
                <input type="password"  id="checkpassword" placeholder="请再次输入密码">
                <span id="checkpwd" style=" width: 40px"></span>
            </td>
        </tr>
        <tr>
            <td>用户邮箱</td>
            <td>
                <input type="text" name="email" id="checkEmail">
                <span id="checkem" style=" width: 40px"></span>
            </td>

        </tr>
        <tr>
            <td>用户性别</td>
            <td><input type="text" name="gender" placeholder="请输入您的性别,非人类请勿注册谢谢..."></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td style="text-align: center;line-height: 10px">
                <input type="text" name="checkCode" size="4" id="checkCodeId">
                <!--验证码-->
                <a href="javascript:reloadCheckImg();">
                    <img src="checkCode.jsp"/>
                </a>
                <span id="tip"></span>
            </td>
        </tr>

        <tr style="text-align: center">
            <td colspan="2"><input type="submit" value="提交" id="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
