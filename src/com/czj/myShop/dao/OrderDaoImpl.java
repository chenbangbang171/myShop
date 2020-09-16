package com.czj.myShop.dao;

import com.czj.myShop.entity.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {

    public List<Order> queryCurrentOrders(int userId) throws SQLException {
        String sql = "select * from orders where order_userid = " + userId;

        return super.queryBeanList(sql,Order.class);
    }

    public void createOrder(Order order) throws SQLException {
        String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
        Object[] params = {order.getOrder_id(), order.getOrder_userid(), order.getOrder_goodsid(), order.getOrder_price(), order.getOrder_goodsprice(), order.getOrder_status(), order.getOrder_time(), order.getOrder_addressid()};
        update(sql, params);
    }

    public Order queryOrder(int userId, String orderId) throws SQLException {
        String sql = "select * from orders where order_id = ? and order_userid = ?";
        Object[] params = {orderId, userId};

        return super.queryBean(sql,Order.class,params);
    }
}
