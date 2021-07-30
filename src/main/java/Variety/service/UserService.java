package Variety.service;

import Variety.pojo.User;

public interface UserService {
    public  void regist(User user);
    public  User login(User user);
    public  boolean checkByusername(String username);

}
