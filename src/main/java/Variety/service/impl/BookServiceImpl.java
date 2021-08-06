package Variety.service.impl;

import Variety.dao.impl.BookDaoImpl;
import Variety.pojo.Book;
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
}
