package com.czj.myShop.servlet;

import com.czj.myShop.dao.AddressDaoImpl;
import com.czj.myShop.dao.OrderDaoImpl;
import com.czj.myShop.dao.OrderDetailDaoImpl;
import com.czj.myShop.dao.UserDaoImpl;
import com.czj.myShop.entity.Address;
import com.czj.myShop.entity.Order;
import com.czj.myShop.entity.OrderDetail;
import com.czj.myShop.entity.User;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
    private OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
    private UserDaoImpl userDaoImpl = new UserDaoImpl();
    private AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
    private OrderDetailDaoImpl orderDetailDaoImpl = new OrderDetailDaoImpl();

    /**
     * 用户点击下单后进入，将订单返回前端，用户点击确定后进入订单详情
     *
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    public void createOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Random random = new Random();
        int i = random.nextInt(10000);
        String orderId = String.valueOf(i) + String.valueOf(System.currentTimeMillis());

        int userid = (int) request.getSession().getAttribute("userid");
        int goodsid = Integer.parseInt(request.getParameter("goodsId"));
        String order_userName = (String)request.getSession().getAttribute("username");
        int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
        double goodsPrice = Double.parseDouble(request.getParameter("goodsPrice"));
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        //订单初始状态为0，未支付
        int status = 0;
        //当前时间
        SimpleDateFormat s = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
        String date = s.format(new Date());

        //获取收货人地址id
        Address address = addressDaoImpl.queryAddressByUserId(userid);
        int address_id = address.getAddress_id();
        String address_userphone = address.getAddress_userphone();
        String address_detail = address.getAddress_detail();

        //组装order
        Order order = new Order(orderId, userid, goodsid, totalPrice, goodsPrice, status, date, address_id);

        //组装orderDetail
        OrderDetail orderDetail = new OrderDetail(orderId,userid,order_userName,goodsPrice,totalPrice,status,date,address_detail,address_userphone);
        orderDetailDaoImpl.insertOrderDeatil(orderDetail);

        //插入数据库
        orderDaoImpl.createOrder(order);

        PrintWriter writer = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("order", order);
        writer.print(json);
        writer.flush();
        writer.close();

//        //返回前端
//        request.setAttribute("orderInfo", order);
//        request.setAttribute("address_userphone", address_userphone);
//        request.setAttribute("address_detail", address_detail);
//        request.getRequestDispatcher("afterOrder.jsp").forward(request, response);
    }

    public void orderDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String orderId = request.getParameter("orderId");

        int userId = (int) request.getSession().getAttribute("userid");

        Order order = orderDaoImpl.queryOrder(userId, orderId);

        Address address = addressDaoImpl.queryAddressByUserId(userId);
        String address_userphone = address.getAddress_userphone();
        String address_detail = address.getAddress_detail();

        request.setAttribute("orderInfo", order);
        request.setAttribute("address_userphone", address_userphone);
        request.setAttribute("address_detail", address_detail);
        request.getRequestDispatcher("afterOrder.jsp").forward(request, response);
    }

    /**
     * 查询当前订单，不包括历史订单
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @throws IOException
     */
    public void queryCurrentOrders(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userid");

        List<OrderDetail> orderDetails = orderDetailDaoImpl.queryAllOrderDetails(userId);

        request.setAttribute("orderDetails",orderDetails);
        request.getRequestDispatcher("myCurrentOrders.jsp").forward(request,response);
    }



}
