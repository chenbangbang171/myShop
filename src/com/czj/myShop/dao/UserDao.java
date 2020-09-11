package com.czj.myShop.dao;

import com.czj.myShop.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
   /**
   * @param user User类对象
    * @return  影响的行数
   * */
    int addUser(User user) throws SQLException, ClassNotFoundException;

    /**
     * @param id user类对象的id属性
     * @return  影响的行数
     * */
    int deleteUserById(int id) throws SQLException, ClassNotFoundException;

    /**S
     * @param user User类对象
     * @return  影响的行数
     * */
    int updateUser(User user) throws SQLException, ClassNotFoundException;

    /**
     * @param id User类对象的id
     * @return      根据id找的用户
     * */
    User queryUsertById(int id) throws SQLException, ClassNotFoundException;

    /**
     * @return  查询到的所有用户list集合
     * */
    List<User> queryAllUsers() throws SQLException, ClassNotFoundException;

 /**
  * @return  根据用户名和密码查询用户是否存在，用于登录验证
  * */
    User queryUsertByNameAndPwd(String name, String pwd) throws SQLException, ClassNotFoundException;



}
