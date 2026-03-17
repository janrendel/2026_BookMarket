package kr.ac.kopo.janrendel.bookmarket.repository;


import kr.ac.kopo.janrendel.bookmarket.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getALLBookList();

}
