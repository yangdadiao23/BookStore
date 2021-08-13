package test;

import Variety.service.impl.ManagerServiceImpl;
import org.junit.Test;

public class ManagerServiceImplTest {
private  final ManagerServiceImpl managerService=new ManagerServiceImpl();
    @Test
    public void checkManager() {
//        System.out.println(managerService.checkManager("yangchen"));
        managerService.showOrder().stream().forEach(System.out::println);
    }
}