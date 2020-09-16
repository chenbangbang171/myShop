package com.czj.myShop.dao;

import com.czj.myShop.entity.Goods;
import com.czj.myShop.entity.ShoppingCart;

import java.sql.SQLException;
import java.util.List;

public class CartDaoImpl extends BaseDao implements CartDao {

    /**
     * 根据用户id，商品id，商品数量和商品单价，添加一条购物车
     * @param goodsId
     * @param userId
     * @param goodsNumber
     * @param totalPrice
     * @return
     * @throws SQLException
     */
    @Override
    public int insertGoodsToCart(int goodsId, int userId, int goodsNumber, int totalPrice) throws SQLException {
        String sql = "insert into shoppingcart values(?,?,?,?)";
        Object[] params = {userId, goodsId, goodsNumber, totalPrice};
        return update(sql, params);
    }

    /**
     * 根据会员id和商品id获取该条购物车内容
     * @param goodsId
     * @param userId
     * @return
     * @throws SQLException
     */
    @Override
    public ShoppingCart queryGoodsFromCart(int goodsId, int userId) throws SQLException {
        String sql = "select * from shoppingcart where shoppingcart_userid = ? and shoppingcart_goodsid = ? ";
        Object[] params = {userId, goodsId};
        return queryBean(sql, ShoppingCart.class, params);
    }

    /**
     * 购物车以有该条商品，之际在此基础上增加传入数量的商品，并修改该条购物车的总价
     * @param goodsId 要添加的Goods对象
     * @param userId 购物车对应的用户
     * @param goodsNumber
     * @param totalPrice
     * @return
     * @throws SQLException
     */
    @Override
    public int addGoodsToCart(int goodsId, int userId, int goodsNumber, int totalPrice) throws SQLException {
        ShoppingCart shoppingCart = queryGoodsFromCart(goodsId, userId);
        int newNumber = shoppingCart.getShoppingcart_goodsnum() + goodsNumber;
        int newPrice = shoppingCart.getShoppingcart_totalprice() + totalPrice;
        String sql = "update shoppingcart set shoppingcart_goodsnum = ?, shoppingcart_totalprice = ? where shoppingcart_userid = ? and shoppingcart_goodsid = ?";
        Object[] params = {newNumber, newPrice, userId, goodsId};
        return update(sql, params);
    }

    /**
     * 获取该用户的所有购物车内容
     * @param userId
     * @return
     * @throws SQLException
     */
    @Override
    public List<ShoppingCart> getMyCart(int userId) throws SQLException {
        String sql = "select * from shoppingcart where shoppingcart_userid = ?";
        return queryBeanList(sql, ShoppingCart.class, userId);
    }

    /**
     * 对该用户的某一条购物车内容的商品做-1操作
     * @param userid
     * @param goodsId
     * @param goodsNumber
     * @param goodsPrice
     * @param totalPrice
     * @throws SQLException
     */
    @Override
    public void goodsNumberDown(int userid, int goodsId, int goodsNumber, int goodsPrice, int totalPrice) throws SQLException {
        goodsNumber -= 1;
        totalPrice -= goodsPrice;
        Object[] params = {goodsNumber, totalPrice, userid, goodsId};
        String sql = "update shoppingcart set shoppingcart_goodsnum = ? , shoppingcart_totalprice = ? where shoppingcart_userid = ? and shoppingcart_goodsid = ?";

        update(sql, params);
    }

    /**
     * 对该用户的某一条购物车内容的商品做+1操作
     * @param userid
     * @param goodsId
     * @param goodsNumber
     * @param goodsPrice
     * @param totalPrice
     * @throws SQLException
     */
    @Override
    public void goodsNumberUp(int userid, int goodsId, int goodsNumber, int goodsPrice, int totalPrice) throws SQLException {
        goodsNumber += 1;
        totalPrice += goodsPrice;
        Object[] params = {goodsNumber, totalPrice, userid, goodsId};
        String sql = "update shoppingcart set shoppingcart_goodsnum = ? , shoppingcart_totalprice = ? where shoppingcart_userid = ? and shoppingcart_goodsid = ?";

         update(sql, params);
    }

    /**
     * 若某条购物车的商品数量为0，删除该条购物车内容
     * @throws SQLException
     */
    @Override
    public void deleteTheCart() throws SQLException {
        String sql = "delete from shoppingcart where shoppingcart_goodsnum = 0 ";
        update(sql);
    }

    /**
     * 清空该用户的所有条购物车
     * @param userId
     * @throws SQLException
     */
    @Override
    public void clearCart(int userId) throws SQLException {
        String sql = "delete  from shoppingcart where shoppingcart_userid = " + userId;
        update(sql);
    }
}
