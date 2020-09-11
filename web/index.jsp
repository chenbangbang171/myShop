<%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/11
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style type="text/css">
      #title{                 /* 页面标题*/
        width:100px;
        height: 50px;
        text-align:center;
        line-height: 50px;
        border: 1px solid black;
        font-size: 36px;
        font-family: arial;
        color:deepskyblue ;
        background: lightcyan;
      }
      #login{							 /* 登录框*/
        border: 1px solid black;
        width: 400px;
        height: 350px;
        margin:270px  auto;

        border-radius: 8px;

      }
      #stu{								/* 学生选择按钮*/
        width: 197px;
        height: 50px;
        border: 0px ;
        border-right:0px solid black ;
        text-align: center;
        line-height: 50px;
        font-size: 20px;
        display: inline-block;
      }
      #tec{								/* 老师选择按钮*/
        width: 197px;
        height: 50px;
        border: 0px ;
        border-left:1px solid black ;
        text-align: center;
        line-height: 50px;
        font-size: 20px;
        display: inline-block;
      }
      #input{								/* 登录输入框-外*/
        margin-top: 30px;
        margin-left: 70px;
      }
      input{           					/* 登录输入框-内*/
        height: 35px;
        width: 210px;
        margin-top: 25px;
        margin-left: 8px;
      }
      #smt{
        width: 80px;
        height: 35px;
        margin-left: 160px;
        margin-top: 30px;
        background: lightskyblue ;
        border-radius: 8px;
      }
      #span{
        float: right;
        margin-top: 50px;
      }
    </style>
  </head>
  <body>
  <div id="dv">
    <div id="title">myShop</div>
    <form action="UserServlet?method=login" method="post" >
      <div id="login">
        <div id="input">
          用户名：<input type="text" name="username" id="uid" value="" placeholder="请输入账号..." /><br />
          密码：<input type="password" name="password" id="pass" value="" placeholder="请输入密码..." />
        </div>
        <div id="btn">
          <input type="submit" name="submit" id="smt" value="登录" />
        </div>
        <span id="span">
					<a  href="regist.html">还没有账号？点我注册！</a>
				</span>
      </div>
    </form>


  </div>
  </body>
</html>
