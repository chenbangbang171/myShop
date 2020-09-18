package com.czj.myShop.dao;

import com.czj.myShop.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    /**
     * @param user User类对象
     * @return 影响的行数
     */
    int addUser(User user) throws SQLException, ClassNotFoundException;

    /**
     * 根据传入的id删除用户
     *
     * @param id user类对象的id属性
     * @return 影响的行数
     */
    int deleteUserById(int id) throws SQLException, ClassNotFoundException;

    /**
     * 根据传入的用户对象，修改该用户
     *
     * @param user
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    int updateUser(User user) throws SQLException, ClassNotFoundException;

    /**
     * 根据用户id查询该用户
     *
     * @param id User类对象的id
     * @return 根据id找的用户
     */
    User queryUsertById(int id) throws SQLException, ClassNotFoundException;

    /**
     * 查询到的所有用户list集合
     *
     * @return
     */
    List<User> queryAllUsers() throws SQLException, ClassNotFoundException;

    /**
     * 根据用户名和密码查询用户是否存在，用于登录验证
     *
     * @return
     */
    User queryUsertByNameAndPwd(String name, String pwd) throws SQLException, ClassNotFoundException;

    /**
     * 用来根据用户的邮箱获取用户id
     *
     * @param email
     * @return
     * @throws SQLException
     */
    User queryUserByEmail(String email) throws SQLException;

    /**
     * 修改用户激活状态并添加激活码
     *
     * @param flag      用户激活状态
     * @param id        用户id
     * @param checkCode 用户的激活码
     * @return
     * @throws SQLException
     */
    int updateFlag(int flag, int id, String checkCode) throws SQLException;

    /**
     * 判断用户是否是激活状态
     *
     * @param id 用户id
     * @return
     * @throws SQLException
     */
    public User isActive(int id) throws SQLException;

    /**
     * 获取该用户的角色
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public User getRole(int id, int role) throws SQLException;

}
