package test;

import Variety.dao.impl.OrderItemDaoImpl;
import org.junit.Test;

public class OrderItemDaoImplTest {
    public final OrderItemDaoImpl orderItemDao=new OrderItemDaoImpl();
    @Test
    public void text() {
       orderItemDao.searchOrderItem("16287679569114").stream().forEach(System.out::println);
        System.out.println(orderItemDao.OrderItemCount());
    }
}