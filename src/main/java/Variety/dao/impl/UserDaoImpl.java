package Variety.dao.impl;

import Variety.dao.UserDao;
import Variety.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryByusername(String username) {
        String sql="select * from t_user where username=?";
       return query(User.class,sql,username);
    }

    @Override
    public User queryByusernameAndpassword(String username, String password) {
        String sql="select * from t_user where username=? and password=?";
        return query(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into t_user(username,password,email) values(?,?,?)";
       return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
