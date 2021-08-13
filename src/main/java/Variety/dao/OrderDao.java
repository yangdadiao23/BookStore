package Variety.dao;

import Variety.pojo.Order;

import java.util.List;

public interface OrderDao {
    public  int saveOrder(Order order);
    public List<Order> showOrder(int user_id);
    public  Order searchOrder(String order_id);
}
