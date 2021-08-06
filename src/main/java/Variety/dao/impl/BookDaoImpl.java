package Variety.dao.impl;

import Variety.dao.BookDao;
import Variety.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql="insert into t_book(name ,author ,price , sales , stock , img_path) values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path());
    }

    @Override
    public int deleteBook(int id) {
        String sql="delete from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql="update t_book set name=? ,author=? ,price=? , sales=? , stock=? , img_path=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(), book.getImg_path(),book.getId());
    }

    @Override
    public Book queryBookById(int id) {
         String sql="select * from t_book where id=?";
        return query(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql="select * from t_book";
        return queryAll(Book.class,sql);
    }
}
