package Variety.service;

import Variety.pojo.Cart;

public interface OrderService {
    public  String createOrder(Cart cart,int user_id);
}
