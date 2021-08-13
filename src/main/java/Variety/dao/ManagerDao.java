package Variety.dao;

import Variety.pojo.Manager;
import Variety.pojo.Order;

import java.util.List;

public interface ManagerDao {
    public Manager queryByUsername(String username);
    public List<Order> queryOrder();
}
