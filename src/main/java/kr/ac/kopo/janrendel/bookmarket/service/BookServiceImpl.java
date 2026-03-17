package kr.ac.kopo.janrendel.bookmarket.service;

import kr.ac.kopo.janrendel.bookmarket.domain.Book;
import kr.ac.kopo.janrendel.bookmarket.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBookList() {
        return bookRepository.getALLBookList();
    }
}
