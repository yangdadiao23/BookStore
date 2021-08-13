package Variety.dao.impl;

import Variety.dao.ManagerDao;
import Variety.pojo.Manager;
import Variety.pojo.Order;

import java.util.List;

public class ManagerDaoImpl extends BaseDao implements ManagerDao {
    @Override
    public Manager queryByUsername(String username) {
       String sql="select * from t_manager where username=?";
       return query(Manager.class,sql,username);
    }

    @Override
    public List<Order> queryOrder() {
        String sql="select * from t_order";
        return  queryAll(Order.class,sql);
    }
}
