package Variety.service.impl;

import Variety.dao.impl.UserDaoImpl;
import Variety.pojo.User;
import Variety.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDaoImpl ud=new UserDaoImpl();
    @Override
    public  void regist(User user) {
         ud.saveUser(user);
    }

    @Override
    public User login(User user) {
        return  ud.queryByusernameAndpassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean checkByusername(String username) {
        if(ud.queryByusername(username)==null){
            return  false;
        }
        return true;
    }
}
