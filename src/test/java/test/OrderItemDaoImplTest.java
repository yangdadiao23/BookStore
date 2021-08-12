package test;

import Variety.dao.impl.OrderItemDaoImpl;
import Variety.pojo.OrderItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {
    public final OrderItemDaoImpl orderItemDao=new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {
        System.out.println(orderItemDao.saveOrderItem(new OrderItem("操作系统", 2, 200, 200, "abc123")));
    }
}