package com.czj.myShop.dao;

import com.czj.myShop.entity.Goods;
import com.czj.myShop.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface GoodsDao {

    /**
     * @param goods 要添加的Goods对象
     * @return  影响的行数
     * */
    int addGoods(Goods goods) throws SQLException, ClassNotFoundException;


    /**
     * @param id Goods类对象的id属性
     * @return  影响的行数
     * */
    int deleteGoodsById(int id) throws SQLException, ClassNotFoundException;

    /**
     * @param goods 要修改的Goods对象
     * @return  影响的行数
     * */
    int updateGoods(Goods goods) throws SQLException, ClassNotFoundException;


    /**
     * @param id Goods类对象的id
     * @return      根据id找的商品
     * */
    Goods queryGoodstById(int id) throws SQLException, ClassNotFoundException;

    /**
     * @return  查询到的所有商品list集合
     * */
    List<Goods> queryAllGoods() throws SQLException, ClassNotFoundException;
}
