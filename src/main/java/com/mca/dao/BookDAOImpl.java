package com.mca.dao;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.mca.model.Book;
 
@Repository
public class BookDAOImpl implements BookDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addBook(Book book) {
        sessionFactory.getCurrentSession().saveOrUpdate(book);
 
    }
 
    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks() {
 
        return sessionFactory.getCurrentSession().createQuery("from Book")
                .list();
    }
 
    @Override
    public void deleteBook(Integer bookId) {
        Book book = (Book) sessionFactory.getCurrentSession().load(
                Book.class, bookId);
        if (null != book) {
            this.sessionFactory.getCurrentSession().delete(book);
        }
 
    }
 
    public Book getBook(int empid) {
        return (Book) sessionFactory.getCurrentSession().get(
                Book.class, empid);
    }
 
    @Override
    public Book updateBook(Book book) {
        sessionFactory.getCurrentSession().update(book);
        return book;
    }
 
}