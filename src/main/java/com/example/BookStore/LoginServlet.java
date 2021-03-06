package com.example.BookStore;

import Variety.pojo.User;
import Variety.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServiceImpl us = new UserServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(us.login(new User(username,password))!=null){
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","用户名或密码错误！");
            System.out.println(request.getParameter("msg"));
            request.setAttribute("username",username);
            System.out.println(request.getParameter("username"));
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }


    }
}
