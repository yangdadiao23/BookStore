package Variety.dao.impl;

import Variety.dao.OrderDao;
import Variety.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql="insert into t_order values(?,?,?,?,?)";
        return update(sql,order.getOrder_id(),order.getCreate_time(),order.getPrice(),order.getStatus(),order.getUser_id());
    }

    @Override
    public List<Order> showOrder(int user_id) {
       String sql="select * from t_order where user_id=? ";
       return queryAll(Order.class,sql,user_id);
    }

    @Override
    public Order searchOrder(String order_id) {
        String sql="select * from t_order where order_id=?";
        return  query(Order.class,sql,order_id);
    }


}
