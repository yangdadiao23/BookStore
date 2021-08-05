package com.example.BookStore;

import Variety.pojo.User;
import Variety.service.impl.UserServiceImpl;
import Variety.utils.beanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet {
 private  final    UserServiceImpl us = new UserServiceImpl();

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //  1、获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        User user = beanUtils.ParameterToBean(request.getParameterMap(), new User());

//        2、检查 验证码是否正确  === 写死,要求验证码为:qwe
        if ("qwe".equalsIgnoreCase(code)) {
//        3、检查 用户名是否可用
            if (us.checkByusername(username)) {
                System.out.println("用户名[" + username + "]已存在!");

                // 把回显信息，保存到Request域中
                request.setAttribute("msg", "用户名已存在！！");
                System.out.println(request.getAttribute("msg"));
                request.setAttribute("username", username);
                request.setAttribute("email", email);

//        跳回注册页面
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                //      可用
//                调用Sservice保存到数据库
                us.regist(new User( username, password, email));
//
//        跳到注册成功页面 regist_success.jsp
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            // 把回显信息，保存到Request域中
            request.setAttribute("msg", "验证码错误！！");
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            System.out.println("验证码[" + code + "]错误");
            System.out.println(request.getAttribute("msg"));
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }

    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(us.login(new User(username,password))!=null){
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","用户名或密码错误！");
            System.out.println(request.getParameter("msg"));
            request.setAttribute("username",username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }
    }
}
