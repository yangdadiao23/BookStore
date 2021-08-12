package com.example.BookStore;

import Variety.pojo.Book;
import Variety.pojo.Cart;
import Variety.pojo.CartItem;
import Variety.service.impl.BookServiceImpl;
import Variety.utils.ToolsUtils;
import com.google.gson.Gson;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.invoke.LambdaConversionException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {
    private BookServiceImpl bookService=new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void AjaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String string_id = request.getParameter("id");
        int id=0;
        if(string_id!=null){
            id=ToolsUtils.StringToint(string_id);
        }
        Book book = bookService.queryBookById(id);
        System.out.println(book);
        Cart cart= (Cart) request.getSession().getAttribute("cart");
        if(cart==null){
            cart=new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(new CartItem(book.getId(),book.getName(),1,book.getPrice(), book.getPrice()));
        request.getSession().setAttribute("lastName", book.getName());
        Map<String,Object>map=new HashMap<>();
        map.put("totalCount",cart.getTotalCount());
        map.put("lastName", book.getName());
        Gson gson=new Gson();
        String s = gson.toJson(map);
        response.getWriter().write(s);
    }

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String string_id = request.getParameter("id");
        int id=0;
        if(string_id!=null){
          id=ToolsUtils.StringToint(string_id);
        }
        Book book = bookService.queryBookById(id);
        System.out.println(book);
        Cart cart= (Cart) request.getSession().getAttribute("cart");
        if(cart==null){
            cart=new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(new CartItem(book.getId(),book.getName(),1,book.getPrice(), book.getPrice()));
        request.getSession().setAttribute("lastName", book.getName());
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String string_id = request.getParameter("id");
        int id=0;
        if(string_id!=null&&string_id!=""){
            id=ToolsUtils.StringToint(string_id);
        }
        Cart cart= (Cart) request.getSession().getAttribute("cart");
        if(cart!=null){
            cart.deleteItem(id);
            response.sendRedirect(request.getHeader("referer"));
        }
    }

    protected void clearItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart=(Cart) request.getSession().getAttribute("cart");
        if(cart!=null){
            cart.clearItem();
            response.sendRedirect(request.getHeader("referer"));
        }
    }

    protected void updateItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          int id=0;
          int newCount=1;
        String id1 = request.getParameter("id");
        String count = request.getParameter("count");
        if(id1!=null&&id1!=""){
            id=ToolsUtils.StringToint(id1);
        }
        if(count!=null&&count!=""){
            newCount=ToolsUtils.StringToint(count);
        }
        Cart cart=(Cart) request.getSession().getAttribute("cart");
        if(cart!=null){
            cart.updateCount(id,newCount);
            response.sendRedirect(request.getHeader("referer"));
        }
    }


}
