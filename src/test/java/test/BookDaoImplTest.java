package test;

import Variety.dao.impl.BookDaoImpl;
import Variety.pojo.Book;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest {
    private BookDaoImpl bookDao=new BookDaoImpl();
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addBook() {
        System.out.println(bookDao.addBook(new Book("操作系统", 35, "小黑", 100, 500, "static/img/default.jpg")));
    }

    @Test
    public void deleteBook() {
        System.out.println(bookDao.deleteBook(7));
    }

    @Test
    public void updateBook() {
        System.out.println(bookDao.updateBook(new Book(8, "操作系统", 50, "小黑", 100, 500, "static/img/default.jpg")));
    }

    @Test
    public void queryBookById() {
        System.out.println( bookDao.queryBookById(8));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        books.stream().forEach(System.out::println);
    }
}