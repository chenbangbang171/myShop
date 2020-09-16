package com.czj.myShop.dao;

import com.czj.myShop.entity.Goods;
import com.czj.myShop.entity.ShoppingCart;

import java.sql.SQLException;
import java.util.List;

public interface CartDao  {
    /**
     * @param goodsId 要添加的Goods对象
     * @param userId 购物车对应的用户
     * @return  影响的行数
     * */
    int addGoodsToCart(int goodsId,int userId,int goodsNumber, int totalPrice) throws SQLException, ClassNotFoundException;

    ShoppingCart queryGoodsFromCart(int goodsId, int userId) throws SQLException;

    int insertGoodsToCart(int goodsId, int userId, int goodsNumber, int totalPrice) throws SQLException;

     List<ShoppingCart> getMyCart(int userId) throws SQLException;

    void goodsNumberDown(int userid, int goodsId, int goodsNumber, int goodsPrice, int totalPrice) throws SQLException;

    void goodsNumberUp(int userid, int goodsId, int goodsNumber, int goodsPrice, int totalPrice) throws SQLException;

    void deleteTheCart() throws SQLException;

    void clearCart(int userId) throws SQLException;

}
