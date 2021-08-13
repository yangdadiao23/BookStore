package Variety.dao;

import Variety.pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {
    public  int saveOrderItem(OrderItem orderItem);
    public List<OrderItem> searchOrderItem(String order_id);
    public int OrderItemCount();
}
