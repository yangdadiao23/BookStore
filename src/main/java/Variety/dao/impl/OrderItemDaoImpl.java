package Variety.dao.impl;

import Variety.dao.OrderItemDao;
import Variety.pojo.OrderItem;
import jdk.nashorn.internal.objects.annotations.Constructor;

import java.util.List;

public class OrderItemDaoImpl extends  BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql="insert into t_order_item(name,count,price,total_price,order_id) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotal_price(),orderItem.getOrder_id());

    }

    @Override
    public List<OrderItem> searchOrderItem(String order_id) {
        String sql="select * from t_order_item where order_id=?";
        return  queryAll(OrderItem.class,sql,order_id);
    }

    @Override
    public int OrderItemCount(){
        String sql="select count(*) from t_order_item";
        return  (int)querySingle(sql);
    }
}
