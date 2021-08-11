package test;

import Variety.pojo.Cart;
import Variety.pojo.CartItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {

    private    Cart cart= new Cart();
    @Test
    public void addItem() {
        cart.addItem(new CartItem(1,"数据结构",1,20,20));
        cart.addItem(new CartItem(2,"dada",4,15,60));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        cart.addItem(new CartItem(1,"数据结构",1,20,20));
        System.out.println(cart);
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        cart.addItem(new CartItem(1,"数据结构",1,20,20));
        System.out.println(cart);
        cart.updateCount(1,4);
        System.out.println(cart);
    }

    @Test
    public void clearItem() {
        cart.addItem(new CartItem(1,"数据结构",1,20,20));
        System.out.println(cart);
        cart.clearItem();
        System.out.println(cart);

    }
}