package Variety.service;

import Variety.pojo.Manager;
import Variety.pojo.Order;

import java.util.List;

public interface ManagerService {
    public Manager checkManager(String username);
    public List<Order>showOrder();
}
