package Variety.service.impl;

import Variety.dao.impl.OrderDaoImpl;
import Variety.dao.impl.OrderItemDaoImpl;
import Variety.pojo.*;
import Variety.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDaoImpl orderDao=new OrderDaoImpl();
     private  OrderItemDaoImpl orderItemDao=new OrderItemDaoImpl();
     private  BookServiceImpl bookService=new BookServiceImpl();
    @Override
    public String createOrder(Cart cart, int user_id) {
        String order_id=System.currentTimeMillis()+""+user_id;
        orderDao.saveOrder(new Order(order_id,new Date(),cart.getTotalPrice(),0,user_id));
        for(Map.Entry<Integer, CartItem> entry:cart.getItems().entrySet()) {
            CartItem item = entry.getValue();
            orderItemDao.saveOrderItem(new OrderItem(item.getName(), item.getCount(), item.getPrice(), item.getTotalPrice(), order_id));
            Book book = bookService.queryBookById(item.getId());
            book.setSales(book.getSales()+item.getCount());
            book.setStock(book.getStock()-item.getCount());
            bookService.updateBook(book);
        }
        cart.clearItem();
        return order_id;
    }

    @Override
    public List<Order> showOrder(int user_id) {
       return orderDao.showOrder(user_id);
    }

    @Override
    public List<OrderItem> searchOrderItem(String order_Id) {
        return orderItemDao.searchOrderItem(order_Id);
    }


}
