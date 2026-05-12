package kr.ac.kopo.janrendel.bookmarket.service;

import java.util.List;
import kr.ac.kopo.janrendel.bookmarket.domain.Book;
import kr.ac.kopo.janrendel.bookmarket.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBookList() {
        return bookRepository.getALLBookList();
    }

    @Override
    public Book getBookByID(String BookId) {
        Book book = bookRepository.getBookByID(BookId);
        return book;
    }

    @Override
    public List<Book> getBookByCategory(String category) {
        List<Book> bookByCategory = bookRepository.getBookListByCategory((category));
        return bookByCategory;
    }

    @Override
    public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
        Set<Book> bookByFilter = bookRepository.getBookListByFilter(filter);
        return bookByFilter;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.setNewBook(book);
    }

    @Override
    public void setNewBook(Book book) {
        bookRepository.setNewBook(book);
    }


}
