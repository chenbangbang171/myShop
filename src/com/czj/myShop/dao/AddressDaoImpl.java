package com.czj.myShop.dao;

import com.czj.myShop.entity.Address;

import java.sql.SQLException;

public class AddressDaoImpl extends BaseDao implements AddressDao {
    public Address queryAddressByUserId(int userId) throws SQLException {
        String sql = "select * from address where address_userid = " + userId;
        return super.queryBean(sql,Address.class);
    }
}
