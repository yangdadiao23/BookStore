package test;

import Variety.pojo.Cart;
import Variety.pojo.CartItem;
import Variety.service.impl.OrderServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderServiceImplTest {
   private  final    OrderServiceImpl orderService=new OrderServiceImpl();
    @Test
    public void createOrder() {
        Cart cart= new Cart();
        cart.addItem(new CartItem(1,"数据结构",1,20,20));
        cart.addItem(new CartItem(2,"dada",4,15,60));
        System.out.println( orderService.createOrder(cart, 1));
    }
}