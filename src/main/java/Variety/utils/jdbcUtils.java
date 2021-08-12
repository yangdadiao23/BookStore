package Variety.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;
import com.mysql.jdbc.ConnectionFeatureNotAvailableException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *功能描述：使用druid连接池连接数据库
 * BeanHandler<> BeanListHandler<> 对象的结果集
 * ScalarHandler<>                  特殊值的结果集
 */


public class jdbcUtils {
    private  static DruidDataSource dataSource;
    private  static  ThreadLocal<Connection>conns=new ThreadLocal<>();
    static {
        Properties properties=new Properties();
        InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        //读取jdbc.properties属性配置文件
        try {
            properties.load(resourceAsStream);//从流中加载数据
            try {
                dataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);//创建数据库连接池
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
    获取数据库连接池中的连接
     */
    public  static Connection getConnection(){
        Connection conn=conns.get();
        if(conn==null){
            try {
                conn=dataSource.getConnection();
                conns.set(conn);
                conn.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }

    /*
    关闭连接，放回数据库连接池
     */
   /* public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }*/

    public static void commitAndClose(){
        Connection connection=conns.get();
        if(connection!=null){
            try {
                connection. commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();

    }

    public static void RollbackAndClose(){
        Connection connection=conns.get();
        if(connection!=null){
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();
    }
}