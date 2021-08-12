package com.example.BookStore;

import Variety.pojo.Cart;
import Variety.pojo.User;
import Variety.service.impl.BookServiceImpl;
import Variety.service.impl.OrderServiceImpl;
import Variety.utils.jdbcUtils;
import com.alibaba.druid.util.JdbcUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OrderServlet extends BaseServlet {
    private  final OrderServiceImpl orderService=new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }


    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart =(Cart) request.getSession().getAttribute("cart");
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }
        int user_id=user.getId();
        String order_id= orderService.createOrder(cart, user_id);
        request.getSession().setAttribute("order_id",order_id);
        response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
