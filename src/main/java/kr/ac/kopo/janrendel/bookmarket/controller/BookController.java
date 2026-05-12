package kr.ac.kopo.janrendel.bookmarket.controller;

import kr.ac.kopo.janrendel.bookmarket.domain.Book;
import kr.ac.kopo.janrendel.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Value("%{file.uploadDir}")
    String fileDir;

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

    @GetMapping("/add")
    public String requestAddBookForm(){
        return "addBook";
    }

    @PostMapping("/add")
    public String requestSubmitNewBook(@Validated @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "addBook";
        }
        MultipartFile bookImage = book.getBookImage();
        String saveName = bookImage.getOriginalFilename();
        File saveFile  = new File(fileDir + saveName);
        if(bookImage != null && !bookImage.isEmpty()) {
            try {
                bookImage.transferTo(saveFile);
            } catch (IOException e) {
                throw new RuntimeException("도서 이미지 업로드가 되지 않았습니다.");
            }
        }
        return "redirect:/books";
    }

    @ModelAttribute
    public void addAddtributes(Model model){
        model.addAttribute("addTitle", "신규 도서 등록");


    }
}