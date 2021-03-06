package com.example.Filter;

import Variety.pojo.Manager;
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
      Manager manager=(Manager) ((HttpServletRequest) request).getSession().getAttribute("manager");
       if(manager==null){
           request.getRequestDispatcher("/pages/manager/manager_login.jsp").forward(request,response);
       }
        chain.doFilter(request, response);
    }
}
