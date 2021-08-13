package com.example.BookStore;

import Variety.pojo.Manager;
import Variety.pojo.Order;
import Variety.pojo.User;
import Variety.service.impl.ManagerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ManagerServlet extends BaseServlet {
  private  final   ManagerServiceImpl managerService=new ManagerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }



    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Manager manager=managerService.checkManager(username);
        if(manager!=null){
            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("manager",manager);
            request.getRequestDispatcher("/pages/manager/manager.jsp").forward(request,response);
        }else {
            request.setAttribute("msg", "用户名或密码错误！");
            System.out.println(request.getParameter("msg"));
            request.setAttribute("username", username);
            request.getRequestDispatcher("/pages/manager/manager_login.jsp").forward(request, response);
        }
    }

    protected void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = managerService.showOrder();
        request.getSession().setAttribute("orders",orders);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,response);

    }
}
