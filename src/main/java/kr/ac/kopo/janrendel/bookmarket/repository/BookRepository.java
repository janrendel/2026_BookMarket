package kr.ac.kopo.janrendel.bookmarket.repository;


import kr.ac.kopo.janrendel.bookmarket.domain.Book;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BookRepository {
    List<Book> getALLBookList();
    Book getBookByID(String bookId);
    List<Book> getBookListByCategory(String category);
    Set<Book> getBookListByFilter(Map<String, List<String>> filter);
    void setNewBook(Book book);
}
