package com.czj.myShop.dao;

import com.czj.myShop.entity.OrderDetail;

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


}
