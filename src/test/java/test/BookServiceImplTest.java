package test;

import Variety.pojo.Page;
import Variety.service.impl.BookServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest {
     private final BookServiceImpl bookService= new BookServiceImpl();
    @Test
    public void addBook() {
    }

    @Test
    public void deleteBookById() {
        System.out.println(bookService.deleteBookById(6));
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void queryBookById() {
        System.out.println( bookService.queryBookById(8));
    }

    @Test
    public void Test() {

        Page page = bookService.pageByPrice(3, 4, 1, 10);
        List items = page.getItems();
        System.out.println(page);
        items.stream().forEach(System.out::println);


    }
}