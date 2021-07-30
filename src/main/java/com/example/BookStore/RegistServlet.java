package com.example.BookStore;

import Variety.pojo.User;
import Variety.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImpl us = new UserServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email= request.getParameter("email");
        String code = request.getParameter("code");
        if("qwe".equals(code)){
            if(us.checkByusername(username)){
                System.out.println("用户名已存在！");
                request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
            }else{
                System.out.println("注册成功！");
                us.regist(new User(username,password,email));
                request.getRequestDispatcher("/pages/user/regist_success.html").forward(request,response);
            }
        }else{
            System.out.println("验证码错误!");
            request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
        }

    }
}
