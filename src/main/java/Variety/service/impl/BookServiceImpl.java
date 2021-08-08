package Variety.service.impl;

import Variety.dao.impl.BookDaoImpl;
import Variety.pojo.Book;
import Variety.pojo.Page;
import Variety.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDaoImpl bookDao=new BookDaoImpl();
    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return bookDao.deleteBook(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(int id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();

    }

    @Override
    public Page queryBookByPage(int pageNo, int pageSize) {
        Page<Book> bookPage = new Page<>();
        bookPage.setPageSize(pageSize);
        int totalCount=bookDao.QueryPageTotalCount();
        bookPage.setPageTotalCount(totalCount);
         int pageTotal=totalCount/pageSize;
         if(totalCount%pageSize>0){
             pageTotal++;
         }
         if(pageNo<1)pageNo=1;
         if(pageNo>pageTotal)pageNo=pageTotal;
        bookPage.setPageNo(pageNo);
        bookPage.setPageTotal(pageTotal);
         List<Book>items=bookDao.queryItems(pageNo,pageSize);
        bookPage.setItems(items);
        return bookPage;
    }

    @Override
    public Page pageByPrice(int pageNo,int pageSize , int min, int max) {
       int PageTotalCount=bookDao.QueryPageTotalCount(min,max);
       List<Book> PageItems=bookDao.queryItems(pageNo,pageSize,min,max);
        Page<Book> bookPage = new Page<>();

        int pageTotal=PageTotalCount/pageSize;
        if(PageTotalCount%pageSize>0){
            pageTotal++;
        }
        bookPage.setPageNo(pageNo);
        bookPage.setPageTotal(pageTotal);
        bookPage.setPageSize(pageSize);
        bookPage.setItems(PageItems);
        bookPage.setPageTotalCount(PageTotalCount);
        return bookPage;
    }
}
