package Variety.dao;

import Variety.pojo.Book;

import java.util.List;

public interface BookDao {
    public  int addBook(Book book);

    public  int deleteBook(int id);

    public  int updateBook(Book book);

    public  Book queryBookById(int id);

    public List<Book>queryBooks();


    public int QueryPageTotalCount();


    List<Book> queryItems(int pageNo, int pageSize);

    int QueryPageTotalCount(int min, int max);

    List<Book> queryItems(int pageNo, int pageSize, int min, int max);
}
