package Variety.dao;

import Variety.pojo.User;

public interface UserDao {
    public User queryByusername(String username);


    public User queryByusernameAndpassword(String username,String password);

    public int saveUser(User user);

}
