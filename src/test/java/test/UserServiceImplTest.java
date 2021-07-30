package test;

import Variety.dao.impl.UserDaoImpl;
import Variety.pojo.User;
import Variety.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

class UserServiceImplTest {

    @Test
    void regist() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.regist(new User("xh","123456","13515@qq.com"));
        UserDaoImpl userDao = new UserDaoImpl();
        User xh = userDao.queryByusername("xh");
        System.out.println(xh);
    }

    @Test
    void login() {
        UserServiceImpl userService = new UserServiceImpl();
        User yc = userService.login(new User("yc", "123456"));
        System.out.println(yc);
    }

    @Test
    void checkByusername() {
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println(userService.checkByusername("xh"));
    }
}