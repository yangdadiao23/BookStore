package Variety.service;

import Variety.pojo.Book;

import java.util.List;

public interface BookService {
    public  int addBook(Book book);

    public  int deleteBookById(int id);

    public  int updateBook(Book book);

    public  Book queryBookById(int id);

    public List<Book> queryBooks();
}
