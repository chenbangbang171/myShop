package com.czj.myShop.servlet;

import com.czj.myShop.dao.GoodsDaoImpl;
import com.czj.myShop.dao.OrderDaoImpl;
import com.czj.myShop.dao.OrderDetailDao;
import com.czj.myShop.dao.OrderDetailDaoImpl;
import com.czj.myShop.entity.Appraise;
import com.czj.myShop.entity.Goods;
import com.czj.myShop.entity.Order;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/UpdateOrderServlet")
public class UpdateOrderServlet extends BaseServlet {
    private OrderDetailDaoImpl orderDetailDaoImpl = new OrderDetailDaoImpl();
    private OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
    private GoodsDaoImpl goodsDaoImpl = new GoodsDaoImpl();

    public void pay(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String orderId = request.getParameter("orderId");
        int userId = (int) request.getSession().getAttribute("userid");
        int orderStatus = Integer.parseInt(request.getParameter("orderStatus")) + 1;

        orderDetailDaoImpl.updateOrderStatus(userId, orderId, orderStatus);

        PrintWriter writer = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("msg", "支付成功！！！");
        writer.print(json);
        writer.flush();
        writer.close();

    }

    public void confirm(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String orderId = request.getParameter("orderId");
        int userId = (int) request.getSession().getAttribute("userid");
        int orderStatus = Integer.parseInt(request.getParameter("orderStatus")) + 1;

        orderDetailDaoImpl.updateOrderStatus(userId, orderId, orderStatus);

        PrintWriter writer = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("msg", "确认收货成功！！！");
        writer.print(json);
        writer.flush();
        writer.close();

    }

    public void appraise(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String orderId = request.getParameter("orderId");
        int userId = (int) request.getSession().getAttribute("userid");
        Order order = orderDaoImpl.queryOrder(userId, orderId);

        Goods goods = goodsDaoImpl.queryGoodstById(order.getOrder_goodsid());
        int goodsId = goods.getGoods_id();
        String goods_name = goods.getGoods_name();
        int goods_price = goods.getGoods_price();

        String goods_pic = goods.getGoods_picture();
        String order_time = order.getOrder_time();
        String username = (String) request.getSession().getAttribute("username");
        Appraise appraise = new Appraise(orderId, username, goods_name, goods_pic, order_time);

        request.setAttribute("appraise", appraise);
        request.setAttribute("goods_price", goods_price);
        request.getRequestDispatcher("makeMyAppraise.jsp").forward(request, response);
    }

    public void makeMyAppraise(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException {
        String username = (String)request.getSession().getAttribute("username");

        int userId = (int)request.getSession().getAttribute("userid");
        int star = Integer.parseInt(request.getParameter("star"));
        String appraiseContext = request.getParameter("appraise");
        String orderId = request.getParameter("orderId");
        System.out.println(orderId);
        Order order = orderDaoImpl.queryOrder(userId, orderId);
        Appraise appraise = new Appraise(orderId,username, star,appraiseContext);

        System.out.println("goodsId:"+order.getOrder_goodsid());
        System.out.println("userId:"+userId);
        System.out.println("appraise:"+appraise);

        orderDetailDaoImpl.insertAppraise(order.getOrder_goodsid(),appraise,userId);
        int order_status = order.getOrder_status() + 1;
        orderDetailDaoImpl.updateOrderStatus(userId, orderId, order_status);

        PrintWriter writer = response.getWriter();
        JSONObject json = new JSONObject();

        json.put("msg","评价成功！");
        writer.print(json);
        writer.flush();
        writer.close();
    }

}
