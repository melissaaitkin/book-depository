package com.mca.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.mca.dao.BookDAO;
import com.mca.model.Book;
 
@Service
@Transactional
public class BookServiceImpl implements BookService {
 
    @Autowired
    private BookDAO bookDAO;
 
    @Override
    @Transactional
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }
 
    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }
 
    @Override
    @Transactional
    public void deleteBook(int empid) {
        bookDAO.deleteBook(empid);
    }
 
    public Book getBook(int empid) {
        return bookDAO.getBook(empid);
    }
 
    public Book updateBook(Book book) {
        // TODO Auto-generated method stub
        return bookDAO.updateBook(book);
    }
 
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
 
}