package com.czj.myShop.dao;

import com.czj.myShop.utils.Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BaseDao {

    private static QueryRunner queryRunner = new QueryRunner(Utils.getDataSource());

    public static int update(String sql, Object... parameters) throws SQLException {
        return queryRunner.update(sql, parameters);
    }

    public <T> T queryBean(String sql, Class<T> cls, Object... parameters) throws SQLException {
        return queryRunner.query(sql, new BeanHandler<>(cls), parameters);
    }

    public <T> List<T> queryBeanList(String sql, Class<T> cls, Object... parameters) throws SQLException {
        return queryRunner.query(sql, new BeanListHandler<>(cls), parameters);
    }

    public Object[] queryArrayBean(String sql, Object... parameters) throws SQLException {
        return queryRunner.query(sql, new ArrayHandler(), parameters);
    }

    public Map<String, Object> queryMapBean(String sql, Object... parameters) throws SQLException {
        return queryRunner.query(sql, new MapHandler(), parameters);
    }

    public List<Map<String, Object>> queryBeanListMap(String sql, Object... parameters) throws SQLException {
        return queryRunner.query(sql, new MapListHandler(),parameters);
    }

}
