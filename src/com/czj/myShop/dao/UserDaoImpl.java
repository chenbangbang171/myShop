package com.czj.myShop.dao;


import com.czj.myShop.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public int addUser(User user) throws SQLException {
        String sql = "insert into user values(?,?,?,?,?,?,?,?)";
        Object[] parameters = {user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getGender(), user.getFlag(), user.getRole(), user.getCode()};
        return update(sql, parameters);
    }

    @Override
    public int deleteUserById(int id) throws SQLException {
        String sql = "delete from user where id = " + id;
        return update(sql);
    }

    @Override
    public int updateUser(User user) throws SQLException {
        String sql = "update user set username = ?, password = ? , email = ?, gender = ?,flag = ? , role = ? , code = ? where id = ? ";
        Object[] parameters = {user.getUsername(), user.getPassword(), user.getEmail(), user.getGender(), user.getFlag(), user.getRole(), user.getCode(), user.getId()};
        return update(sql, parameters);
    }

    @Override
    public User queryUsertById(int id) throws SQLException {
        String sql = "select  * from user where id = ?";
        return super.queryBean(sql, User.class, id);
    }

    public User queryUsertByName(String name) throws SQLException {
        String sql = "select  * from user where username = ?";
        return super.queryBean(sql, User.class, name);
    }

    @Override
    public User queryUsertByNameAndPwd(String name, String pwd) throws SQLException {
        String sql = "select  * from user where username = ? and password = ? ";
        Object[] params = {name, pwd};
        return super.queryBean(sql, User.class, params);
    }

    @Override
    public List<User> queryAllUsers() throws SQLException {
        String sql = "select  * from user ";
        return super.queryBeanList(sql, User.class);
    }

    /**
     * 用来根据用户的邮箱获取用户id
     *
     * @param email 用户邮箱，
     * @return   User 将该用户返回
     * @throws SQLException
     */
    @Override
    public User queryUserByEmail(String email) throws SQLException {
        String sql = "select  * from user  where email = ?";
        User user = super.queryBean(sql, User.class, email);
        return user;

    }

    /**
     *   修改用户激活状态并添加激活码
     * @param flag  用户激活状态
     * @param id    用户id
     * @param checkCode 用户的激活码
     * @return
     * @throws SQLException
     */
    @Override
    public int updateFlag(int flag, int id, String checkCode) throws SQLException {
        String sql = "update user set flag = ? , code = ? where id = ?";
        Object[] params = {flag, checkCode, id};

        return update(sql, params);
    }

    /**
     *  判断用户是否是激活状态
     * @param id  用户id
     * @return
     * @throws SQLException
     */
    @Override
    public User isActive(int id) throws SQLException {
        String sql = "select * from user where id = ? and flag = 1";
        return queryBean(sql,User.class,id);

    }

    /**
     * 获取该用户的角色
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public User getRole(int id,int role) throws SQLException {
        String sql = "select role from user where id = ? and role = ? "  ;
        Object[] params = {id,role};
        return queryBean(sql,User.class,params);
    }


}
