package test;

import Variety.dao.impl.OrderDaoImpl;
import Variety.pojo.Order;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoImplTest {
    public final OrderDaoImpl orderDao=new OrderDaoImpl();
    @Test
    public void saveOrder() {
       // System.out.println(orderDao.saveOrder(new Order("abc123", new Date(), 55, 0, 1)));
        /*orderDao.showOrder(4).stream().forEach(System.out::println);*/
        System.out.println(orderDao.searchOrder("16287679569114"));
    }
}