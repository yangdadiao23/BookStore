package Variety.service;

import Variety.pojo.Book;
import Variety.pojo.Page;

import java.util.List;

public interface BookService {
    public  int addBook(Book book);

    public  int deleteBookById(int id);

    public  int updateBook(Book book);

    public  Book queryBookById(int id);

    public List<Book> queryBooks();

    public Page queryBookByPage(int pageNo, int pageSize);

    public Page pageByPrice( int pageNo ,int pageSize ,int min, int max);
}
