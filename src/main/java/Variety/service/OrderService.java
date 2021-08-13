package Variety.service;

import Variety.pojo.Cart;
import Variety.pojo.Order;
import Variety.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    public  String createOrder(Cart cart,int user_id);
    public List<Order> showOrder(int user_id);
    public  List<OrderItem> searchOrderItem(String order_Id);
}
