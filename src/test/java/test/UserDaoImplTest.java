package test;

import Variety.dao.impl.UserDaoImpl;
import Variety.pojo.User;
import org.junit.jupiter.api.Test;

class UserDaoImplTest {

    @Test
    void queryByusername() {
        UserDaoImpl userDao = new UserDaoImpl();
        User yc = userDao.queryByusername("yc");
        System.out.println(yc);
    }

    @Test
    void queryByusernameAndpassword() {
        UserDaoImpl userDao = new UserDaoImpl();
        User yc = userDao.queryByusernameAndpassword("lxr","123456");
        System.out.println(yc);
    }

    @Test
    void saveUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        int res = userDao.saveUser(new User("lxr", "123456", "165156@qq.com"));
        System.out.println(res);
    }
}