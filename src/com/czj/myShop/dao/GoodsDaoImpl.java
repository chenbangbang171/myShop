package com.czj.myShop.dao;

import com.czj.myShop.entity.Goods;
import com.czj.myShop.entity.User;

import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao{

    /**
     * 添加一个商品数据库
     * @param goods 要添加的Goods对象
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public int addGoods(Goods goods) throws SQLException, ClassNotFoundException {
        String sql = "insert into Goods values(?,?,?,?,?,?,?,?)";
        Object[] params = {goods.getGoods_id(), goods.getGoods_name(), goods.getGoods_date(), goods.getGoods_picture(), goods.getGoods_price(), goods.getGoods_star(), goods.getGoods_info(), goods.getGoods_typeid()};
        return update(sql,params);
    }

    /**
     * 根据一个商品的id删除该商品
     * @param id Goods类对象的id属性
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public int deleteGoodsById(int id) throws SQLException, ClassNotFoundException {
        String sql = "delete from goods where goods_id = "+id;
        return update(sql);
    }

    /**
     * 根据传入的商品对象，修改该商品
     * @param goods 要修改的Goods对象
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public int updateGoods(Goods goods) throws SQLException, ClassNotFoundException {
        String sql = "update goods set goods_name = ?, goods_date = ?, goods_picture = ?, goods_price = ?, goods_star = ?, goods_info = ? ,goods_typeid= ? where goods_id = ?";
        Object[] params = { goods.getGoods_name(), goods.getGoods_date(), goods.getGoods_picture(), goods.getGoods_price(), goods.getGoods_star(), goods.getGoods_info(), goods.getGoods_typeid(),goods.getGoods_id()};
        return update(sql,params);
    }

    /**
     * 根据传入的商品id查询该商品
     * @param id Goods类对象的id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public Goods queryGoodstById(int id) throws SQLException, ClassNotFoundException {
        String sql = "select * from goods where goods_id = " + id;
        return super.queryBean(sql,Goods.class);
    }

    /**
     * 查询所有商品，返回商品列表
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public List<Goods> queryAllGoods() throws SQLException, ClassNotFoundException {
       String sql = "select * from goods";
       return super.queryBeanList(sql,Goods.class);
    }
}
