package com.example.BookStore;

import Variety.pojo.Book;
import Variety.service.impl.BookServiceImpl;
import Variety.utils.ToolsUtils;
import Variety.utils.beanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {

    private  final BookServiceImpl bookService=new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = beanUtils.ParameterToBean(request.getParameterMap(), new Book());
        bookService.addBook(book);
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=list");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String id=request.getParameter("id");
        int i = ToolsUtils.StringToint(id);
        bookService.deleteBookById(i);
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=list");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int i = ToolsUtils.StringToint(id);
        Book book = beanUtils.ParameterToBean(request.getParameterMap(), new Book(i));
        bookService.updateBook(book);
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=list");

    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int i = ToolsUtils.StringToint(id);
        Book book = bookService.queryBookById(i);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
         request.setAttribute("books",books);
         request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }
}
