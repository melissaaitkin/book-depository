package com.mca.dao;
 
import java.util.List;
import com.mca.model.Book;
 
public interface BookDAO {
 
    public void addBook(Book book);
 
    public List<Book> getAllBooks();
 
    public void deleteBook(Integer bookId);
 
    public Book updateBook(Book book);
 
    public Book getBook(int bookid);
}