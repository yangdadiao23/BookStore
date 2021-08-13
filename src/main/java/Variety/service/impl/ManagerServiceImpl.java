package Variety.service.impl;

import Variety.dao.impl.ManagerDaoImpl;
import Variety.pojo.Manager;
import Variety.pojo.Order;
import Variety.service.ManagerService;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {
  private ManagerDaoImpl managerDao= new ManagerDaoImpl();
    @Override
    public Manager checkManager(String username) {
      return  managerDao.queryByUsername(username);
    }

  @Override
  public List<Order> showOrder() {
     return managerDao.queryOrder();
  }
}
