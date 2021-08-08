package Variety.dao.impl;

import Variety.pojo.Book;
import Variety.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private static QueryRunner qr=new QueryRunner();

    public  static  int update(String sql,Object...args){
        Connection con=null;
        try {
           con = jdbcUtils.getConnection();
            return qr.update(con,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcUtils.close(con);
        }
        return -1;
    }


    public static <T> T query(Class<T> clazz,String sql,Object...args){
        Connection con=jdbcUtils.getConnection();
        try {
          return (T) qr.query(con,sql, new BeanHandler<T>(clazz),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtils.close(con);
        }
        return null;
    }

    public static <T>List<T>  queryAll(Class<T> clazz, String sql, Object...args){
        Connection con=jdbcUtils.getConnection();
        try {
            return  qr.query(con,sql,  new BeanListHandler<T>(clazz),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtils.close(con);
        }
        return null;
    }

    public  static Object querySingle(String sql,Object...args){
        Connection con=jdbcUtils.getConnection();
        try {
           return  qr.query(con,sql,new ScalarHandler<>(),args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.close(con);
        }
        return null;
    }


}
