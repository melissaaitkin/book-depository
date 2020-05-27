package com.mca.controller;
 
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
 
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mca.model.Book;
import com.mca.service.BookService;
 
@Controller
public class BookController {
 
    private static final Logger logger = Logger
            .getLogger(BookController.class);
 
    public BookController() {
        System.out.println("BookController()");
    }
 
    @Autowired
    private BookService bookService;
 
    @RequestMapping(value = "/books")
    public ModelAndView listBook(ModelAndView model) throws IOException {
        List<Book> listBook = bookService.getAllBooks();
        model.addObject("listBook", listBook);
        model.setViewName("Books");
        return model;
    }
 
    @RequestMapping(value = "/newBook", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Book book = new Book();
        model.addObject("book", book);
        model.setViewName("BookForm");
        return model;
    }
 
    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    public ModelAndView saveBook(@ModelAttribute Book book) {
        if (book.getId() == 0) { // if book id is 0 then creating the
            // book other updating the book
            bookService.addBook(book);
        } else {
            bookService.updateBook(book);
        }
        return new ModelAndView("redirect:/books");
    }
 
    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public ModelAndView deleteBook(HttpServletRequest request) {
        int bookId = Integer.parseInt(request.getParameter("id"));
        bookService.deleteBook(bookId);
        return new ModelAndView("redirect:/books");
    }
 
    @RequestMapping(value = "/editBook", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int bookId = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.getBook(bookId);
        ModelAndView model = new ModelAndView("BookForm");
        model.addObject("book", book);
 
        return model;
    }
 
}