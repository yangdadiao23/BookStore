package com.example.Filter;

import Variety.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) request;
       User user =(User) httpServletRequest.getSession().getAttribute("user");
       if(user==null){
           request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
       }
        chain.doFilter(request, response);
    }
}
