package com.mca.service;
 
import java.util.List;
 
import com.mca.model.Book;
 
public interface BookService {
     
    public void addBook(Book book);
 
    public List<Book> getAllBooks();
 
    public void deleteBook(int bookid);
 
    public Book getBook(int bookid);
 
    public Book updateBook(Book book);
}