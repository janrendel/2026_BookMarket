package kr.ac.kopo.janrendel.bookmarket.controller;

import kr.ac.kopo.janrendel.bookmarket.domain.Book;
import kr.ac.kopo.janrendel.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String requestVookList(Model model){
        List<Book> listOfBook = bookService.getAllBookList();
        model.addAttribute("bookList",listOfBook);
        return "books";
    }

    @GetMapping("/book")
    public String requestBookId(@RequestParam("id")String bookId,Model model){
        Book book = bookService.getBookByID(bookId);
        model.addAttribute("book",book);
        return "book";
    }

    @GetMapping("/{category}")
    public String requestBooksByCategory(@PathVariable("category") String bookCategory,Model model){
        List<Book> booksByCategory = bookService.getBookByCategory(bookCategory);
        model.addAttribute("bookList",booksByCategory);
        return "books";
    }

    @GetMapping("/filter/{bookFilter}")
    public String requestBooksByFilter(@MatrixVariable(pathVar = "bookFilter")Map<String, List<String>> bookFilter, Model model){
        Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
        model.addAttribute("bookList",booksByFilter);
        return "books";
    }
}