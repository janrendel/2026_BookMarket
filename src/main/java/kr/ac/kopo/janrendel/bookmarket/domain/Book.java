package kr.ac.kopo.janrendel.bookmarket.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

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
    private String fileName; // 도서 이미지 파일
    private MultipartFile bookImage; // 업로드된 도서 이미지 파일
}
