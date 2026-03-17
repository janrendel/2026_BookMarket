package kr.ac.kopo.janrendel.bookmarket.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Book {
    private String BookId; //도서 ID
    private String name; //도서 제목
    private BigDecimal unitPrice; //가격
    private String author; //저자
    private String decription; //설명
    private String publisher; //출판사
    private String category; //분류
    private long unitstock; //재고 수
    private String releaseDate; //출판일
    private String condition; //신규도서, 중고도서, E-Book

}
