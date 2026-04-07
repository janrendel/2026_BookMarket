package kr.ac.kopo.janrendel.bookmarket.controller;

import kr.ac.kopo.janrendel.bookmarket.domain.Book;
import kr.ac.kopo.janrendel.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String requestVookList(Model model){
        List<Book> listOfBooks = bookService.getAllBookList();
        model.addAttribute("bookList,listOfBooks");
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

}