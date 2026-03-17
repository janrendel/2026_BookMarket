package kr.ac.kopo.janrendel.bookmarket.service;

import kr.ac.kopo.janrendel.bookmarket.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBookList();

}
