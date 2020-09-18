package com.czj.myShop.servlet;

import com.czj.myShop.dao.*;
import com.czj.myShop.entity.*;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
    private OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
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
        int i2 = random.nextInt(10000);
        int i3 = random.nextInt(10000);
        int i4 = random.nextInt(10000);

        String orderId = String.valueOf(i) + String.valueOf(i2)+String.valueOf(i3)+String.valueOf(i4);

        int userid = (int) request.getSession().getAttribute("userid");
        int goodsid = Integer.parseInt(request.getParameter("goodsId"));
        String order_userName = (String) request.getSession().getAttribute("username");
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
        OrderDetail orderDetail = new OrderDetail(orderId, userid, order_userName, goodsPrice, totalPrice, status, date, address_detail, address_userphone);
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
     *
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @throws IOException
     */
    public void queryCurrentOrders(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userid");
        List<OrderDetail> orderDetails = orderDetailDaoImpl.queryAllOrderDetails(userId);
        List<OrderDetail> currentOrders = new ArrayList<>();
        for (OrderDetail orderDetail: orderDetails) {
            if (orderDetail.getOrder_status() != 6){
              currentOrders.add(orderDetail);
            }
        }
        request.setAttribute("currentOrders", currentOrders);
        request.getRequestDispatcher("myCurrentOrders.jsp").forward(request, response);
    }

    public void queryAllOrders(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userid");

        List<OrderDetail> orderDetails = orderDetailDaoImpl.queryAllOrderDetails(userId);

        request.setAttribute("orderDetails", orderDetails);
        request.getRequestDispatcher("myAllOrders.jsp").forward(request, response);
    }

    public void queryAllOrdersForManager(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<OrderDetail> orderDetails = orderDetailDaoImpl.queryAllOrdersForManager();
        request.setAttribute("allOrders",orderDetails);
        request.getRequestDispatcher("showOrders.jsp").forward(request,response);
    }

    public void queryOrderById(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String orderId = request.getParameter("orderId");
        OrderDetail orderDetail = orderDetailDaoImpl.queryOrderById(orderId);
        request.setAttribute("orderDetail",orderDetail);
        request.getRequestDispatcher("updateOrder.jsp").forward(request,response);
    }

    public void updateOrderById(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        OrderDetail orderDetail = new OrderDetail();
        BeanUtils.populate(orderDetail, parameterMap);

        orderDetailDaoImpl.updateOrderById(orderDetail);

        response.sendRedirect("OrderServlet?method=queryAllOrdersForManager");
    }


}
