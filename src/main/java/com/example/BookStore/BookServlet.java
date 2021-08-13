package com.example.BookStore;

import Variety.pojo.Book;
import Variety.pojo.Page;
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
        String pageTotal = request.getParameter("pageNo");
        int pageNo;
        if(pageTotal==null){
            pageNo=2;
        }else {
            pageNo=ToolsUtils.StringToint(pageTotal);
        }
        pageNo++;
        Book book = beanUtils.ParameterToBean(request.getParameterMap(), new Book());
        bookService.addBook(book);
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageno = request.getParameter("pageNo");
        int pageNo;
        if(pageno==null){
            pageNo=1;
        }else {
            pageNo=ToolsUtils.StringToint(pageno);
        }
          String id=request.getParameter("id");
        int i = ToolsUtils.StringToint(id);
        bookService.deleteBookById(i);
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageno = request.getParameter("pageNo");
        int pageNo;
        if(pageno==null){
            pageNo=1;
        }else {
            pageNo=ToolsUtils.StringToint(pageno);
        }
        String id = request.getParameter("id");
        int i = ToolsUtils.StringToint(id);
        Book book = beanUtils.ParameterToBean(request.getParameterMap(), new Book(i));
        bookService.updateBook(book);
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);

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

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageSize=4;
        int pageNo=1;
        if(request.getParameter("pageSize")!=null){
            pageSize = ToolsUtils.StringToint(request.getParameter("pageSize"));
        }
        if(request.getParameter("pageNo")!=null){
            pageNo = ToolsUtils.StringToint(request.getParameter("pageNo"));
        }
       Page page=bookService.queryBookByPage(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
       request.setAttribute("page",page);
       request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }
}
