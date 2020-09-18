package com.czj.myShop.dao;

import com.czj.myShop.entity.Appraise;
import com.czj.myShop.entity.Order;
import com.czj.myShop.entity.OrderDetail;

import javax.management.Query;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDaoImpl extends BaseDao implements OrderDetailDao {
    public void insertOrderDeatil(OrderDetail orderDetail) throws SQLException {
        String sql = "insert into orderdetail values(?,?,?,?,?,?,?,?,?)";
        Object[] params = {orderDetail.getOrder_id(), orderDetail.getOrder_userId(), orderDetail.getOrder_userName(), orderDetail.getOrder_goodsPrice(), orderDetail.getOrder_price(), orderDetail.getOrder_status(), orderDetail.getOrder_time(), orderDetail.getOrder_address(), orderDetail.getOrder_phoneNumber()};
        update(sql, params);
    }

    public List<OrderDetail> queryAllOrderDetails(int userId) throws SQLException {
        String sql = "select * from orderdetail where order_userid = " + userId;
        return super.queryBeanList(sql, OrderDetail.class);
    }

    public void updateOrderStatus(int userId, String orderId, int orderStatus) throws SQLException {
        String sql = "update orderdetail set order_status = ? where order_id = ? and order_userid = ? ";
        Object[] params = {orderStatus, orderId, userId};
        update(sql, params);
    }

    public Appraise queryAppraise(int orderId) throws SQLException {
        String sql = "select * from appraise where orderId= " + orderId;
        return super.queryBean(sql, Appraise.class);
    }

    public void insertAppraise(int goodsId, Appraise appraise, int userId) throws SQLException {
        String sql = "insert into appraise values(?,?,?,?,?,?)";
        Object[] params = {appraise.getOrderId(), appraise.getUserName(), goodsId, userId, appraise.getStar(), appraise.getAppraiseContext()};
        update(sql, params);
    }

    public void updateAppraise(String orderId, int star, String appraiseContext) throws SQLException {
        String sql = "update apprasie set appraise_star = ? , appraise_context = ?  where orderID = ?";
        Object[] params = {star, appraiseContext, orderId};
        update(sql, params);
    }

    public List<OrderDetail> queryAllOrdersForManager() throws SQLException {
        String sql = "select * from orderdetail";
        return queryBeanList(sql, OrderDetail.class);
    }


    public OrderDetail queryOrderById(String orderId) throws SQLException {
        String sql = "select * from orderdetail where order_id = " + orderId;
        return super.queryBean(sql, OrderDetail.class);
    }

    public void updateOrderById(OrderDetail orderDetail) throws SQLException {
        String sql = "update orderdetail set  order_status = ?, order_address = ?, order_phoneNumber = ? where order_id = ? ";
        Object[] params = { orderDetail.getOrder_status(),orderDetail.getOrder_address(),orderDetail.getOrder_phoneNumber(),orderDetail.getOrder_id()};
        update(sql,params);
    }
}
