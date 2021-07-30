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
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);
        }else{
            request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
        }
    }
}
