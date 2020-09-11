<%@ page import="java.awt.*" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %><%--
  Created by IntelliJ IDEA.
  User: 陈祖建
  Date: 2020/9/10
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="image/jpeg;charset=UTF-8" language="java" %>

<%!
    //获取随机颜色
    public Color getColor() {
        Random ran = new Random();
        int r = ran.nextInt(256);
        int g = ran.nextInt(256);
        int b = ran.nextInt(256);

        return new Color(r, g, b);
    }

    //获取一个随机数
    public String getNum() {
        Random ran = new Random();
        int num = ran.nextInt(9999);
        return String.valueOf(num);

    }
%>

<%
    //禁止验证码图片缓存
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Expires", "0");

    //获取画笔
    BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
    Graphics graphics = image.getGraphics();

    //画一个长方形
    graphics.fillRect(0, 0, 80, 30);

    //绘制验证码数字
    graphics.setColor(Color.BLACK);

    //设置验证码数字的字体，加粗
    graphics.setFont(new Font("seif",Font.BOLD,20));

    String checkCode = getNum();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < checkCode.length(); i++) {
        sb.append(checkCode.charAt(i) + " ");
    }
    //将生成的验证码数字存到session中，用于用户输入比较
    session.setAttribute("checkCode", checkCode);
    //画验证码数字
    graphics.drawString(sb.toString(),15, 20);


    //绘制干扰线条
    for (int i = 0; i < 30; i++) {
        Random ran = new Random();
        int xStart = ran.nextInt(80);
        int yStart = ran.nextInt(30);
        int xEnd = ran.nextInt(xStart + 10);
        int yEnd = ran.nextInt(yStart + 10);

        graphics.setColor(getColor());

        graphics.drawLine(xStart, yStart, xEnd, yEnd);
    }
    //真实的产生验证码图片
    ImageIO.write(image, "jpeg", response.getOutputStream());

    out.clear();
    //将生成的验证码图片push到所要用的地方
    out = pageContext.pushBody();
%>