package com.example.BookStore;

import Variety.pojo.Page;
import Variety.service.impl.BookServiceImpl;
import Variety.utils.ToolsUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {

    private  final BookServiceImpl bookService=new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("walk go go go！");
        int pageSize=4;
        int pageNo=1;
        if(request.getParameter("pageSize")!=null){
            pageSize = ToolsUtils.StringToint(request.getParameter("pageSize"));
        }
        if(request.getParameter("pageNo")!=null){
            pageNo = ToolsUtils.StringToint(request.getParameter("pageNo"));
        }
        Page page=bookService.queryBookByPage(pageNo,pageSize);
        page.setUrl("client/BookServlet?action=page");
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageSize=4;
        int pageNo=1;
        int min=0;
        int max=Integer.MAX_VALUE;
        StringBuilder sb=new StringBuilder("");
        sb.append("client/BookServlet?action=pageByPrice");
        if(request.getParameter("pageSize")!=null){
            pageSize = ToolsUtils.StringToint(request.getParameter("pageSize"));
        }
        if(request.getParameter("pageNo")!=null){
            pageNo = ToolsUtils.StringToint(request.getParameter("pageNo"));
        }
        if(request.getParameter("min")!=null){
            min = ToolsUtils.StringToint(request.getParameter("min"));
            sb.append("&min="+min);
        }
        if(request.getParameter("max")!=null){
            max = ToolsUtils.StringToint(request.getParameter("max"));
            sb.append("&max="+max);
        }
        Page page=bookService.pageByPrice(pageNo,pageSize,min,max);
        page.setUrl(sb.toString());
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp?min="+min+"&max="+max).forward(request,response);
    }

}
