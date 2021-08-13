package test;

import Variety.dao.impl.ManagerDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerDaoImplTest {
  private  final ManagerDaoImpl managerDao=new ManagerDaoImpl();
    @Test
    public void queryByUsername() {
       /* System.out.println(managerDao.queryByUsername("yangchen"));*/
        managerDao.queryOrder().stream().forEach(System.out::println);
    }
}