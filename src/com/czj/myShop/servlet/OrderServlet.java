package com.czj.myShop.servlet;

import com.czj.myShop.dao.OrderDaoImpl;
import com.czj.myShop.dao.UserDaoImpl;
import com.czj.myShop.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
    private OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
    private UserDaoImpl userDaoImpl = new UserDaoImpl();

    public void createOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int userid = (int)request.getSession().getAttribute("userid");
        String userAddress = "";
        int goodsid = Integer.parseInt(request.getParameter("goodsid"));
        int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
        double goodsPrice1 = Double.parseDouble(request.getParameter("goodsPrice"));
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        //订单初始状态为0，未支付
        int status = 0;

        User user = userDaoImpl.queryUsertById(userid);



    }


}
