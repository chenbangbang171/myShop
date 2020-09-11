package com.czj.myShop.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Utils {


    private static DataSource dataSource;
    public  static DataSource getDataSource(){

        try {
            Properties properties = new Properties();
            properties.load(Utils.class.getClassLoader().getResourceAsStream("druid.properties"));
            DruidDataSourceFactory.createDataSource(properties);
           return dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(ResultSet rs, PreparedStatement pas, Connection conn) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (pas != null) {
            pas.close();
        }
        if (conn != null) {
            conn.close();
        }
    }


    public static PreparedStatement getPreparedStatement (String sql, Connection conn, Object[] parameters) throws SQLException {
        PreparedStatement pas =  conn.prepareStatement(sql);

       //获取参数的个数
        int parametersCount = pas.getParameterMetaData().getParameterCount();
        if(!(parameters.length == 0 ||parametersCount != parameters.length)){
            for (int i = 1; i <= parametersCount ; i++) {
                pas.setObject(i,parameters[i - 1]);
            }
        }
        return pas;
    }

}
