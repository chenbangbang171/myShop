package com.czj.myShop.dao;


import com.czj.myShop.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public int addUser(User user) throws SQLException{
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
    public int updateUser(User user) throws SQLException{
        String sql = "update user set username = ?, password = ? , email = ?, gender = ?,flag = ? , role = ? , code = ? where id = ? ";
        Object[] parameters = {user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getFlag(),user.getRole(),user.getCode() ,user.getId()};
        return update(sql, parameters);
    }

    @Override
    public User queryUsertById(int id) throws SQLException  {
        String sql = "select  * from user where id = ?";
        return super.queryBean(sql, User.class, id);
    }

    @Override
    public User queryUsertByNameAndPwd(String name, String pwd) throws SQLException  {
        String sql = "select  * from user where username = ? and password = ? ";
        Object[] params = {name, pwd};
        return super.queryBean(sql, User.class,params );
    }

    @Override
    public List<User> queryAllUsers() throws SQLException {
        String sql = "select  * from user ";
        return super.queryBeanList(sql, User.class);
    }


}
