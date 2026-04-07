package kr.ac.kopo.janrendel.bookmarket.service;

import kr.ac.kopo.janrendel.bookmarket.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface BookService {
    List<Book> getAllBookList();
    Book getBookByID(String bookId);
    List<Book> getBookByCategory(String category);
    Set<Book> getBookListByFilter(Map<String, List<String>> filter);
}
