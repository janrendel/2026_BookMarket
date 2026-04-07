package kr.ac.kopo.janrendel.bookmarket.repository;

import kr.ac.kopo.janrendel.bookmarket.domain.Book;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;


@Repository
public class BookRepositoryImpl implements BookRepository{
    private List<Book> ListOfBooks = new ArrayList<Book>();

    public BookRepositoryImpl() {
        Book book1 = new Book();
        book1.setBookId("isbn1234");
        book1.setName("스프링 부트 완전정복");
        book1.setDecription("웹 기반의 관공서 위기관리 시스템·의학 용어 온라인 평가 시스템·중도 탈락 예방 시스템 개발, 앱 기반의 전자동화 및 교육용 게임 개발, 유니티를 이용한 가상현실 콘텐츠 개발 등 다양한 실무 경험을" +
                " 쌓고 자바, 웹 프로그래밍(JSP/PHP), 스프링, 안드로이드 프로그래밍, 유니티 엔진, VR/AR 프로그래밍 등을 강의했습니다. 현재 수원여자대학교 교수로 재직하면서 컴퓨터 비전, 모바일 게임, 가상현실 등을 연구...");
        book1.setPublisher("길벗캠퍼스");
        book1.setCategory("IT전문서");
        book1.setAuthor("ooo");
        book1.setUnitPrice(new BigDecimal(35000));
        book1.setReleaseDate("2024/10/31");
        
        Book book2 = new Book();
        book2.setBookId("isbn5435");
        book2.setName("데이터베이스개론");
        book2.setDecription("이터베이스로 첫 항해를 떠나는 이들에게 지도와 돛이 되어주는 책입니다.\n" +
                "마인드맵으로 생소한 개념 간의 관계를 한눈에 보여주고,\n" +
                "친근한 예와 비유를 들어 명료하게 풀어내, 데이터베이스 기본기를 탄탄히 다져줍니다.\n" +
                "3판에서는 빅데이터 표현 기술이 더 추가되었고\n" +
                "다양한 시험의 최신 기술 경향에 맞게 연습문제를 보강하였습니다.");
        book2.setPublisher("한빛아카데미");
        book2.setCategory("IT교육재");
        book1.setAuthor("김연희");
        book2.setUnitPrice(new BigDecimal(29000));
        book2.setReleaseDate("2022/10/15");
        
        Book book3 = new Book();
        book3.setBookId("isbn8675");
        book3.setName("나의 완벽한 장례식");
        book3.setDecription("보통 때라면 손님 한 명 찾기 힘든 새벽 두 시의 병원 매점. 가장 고요해야 할 이 시간, 언제부턴가 수상한 손님들이 하나둘 찾아오기 시작한다. 모두 그림자가 없다는 희한한 공통점을");
        book3.setPublisher("북로망스");
        book3.setCategory("한국소설");
        book1.setAuthor("조현선");
        book3.setUnitPrice(new BigDecimal(17000));
        book3.setReleaseDate("2026/01/21");

        ListOfBooks.add(book1);
        ListOfBooks.add(book2);
        ListOfBooks.add(book3);
    }

    @Override
    public List<Book> getALLBookList() {
        return ListOfBooks;
    }

    @Override
    public Book getBookByID(String bookId){
        Book book = null;
        for (Book serchBook: ListOfBooks){
            if (serchBook != null && serchBook.getBookId() != null && serchBook.getBookId().equals(bookId)){
                book = serchBook;
                break;
            }
        }
        if (book == null){
//            throw new IllegalAccessException("도서ID가"+ bookId + "인 도서는 찾을 수가 없습니다.");
        }
        return book;

    }

    @Override
    public List<Book> getBookListByCategory(String category) {
        List<Book> booksByCategory = new ArrayList<Book>();

        for (Book searchBook : ListOfBooks){
            if (category.equalsIgnoreCase(searchBook.getBookId()))
                booksByCategory.add(searchBook);
        }

        return booksByCategory;


    }

    @Override
    public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
        Set<Book> booksByCategory = new HashSet<Book>();
        Set<Book> booksByPublisher = new HashSet<Book>();
        Set<String> booksByFilter = filter.keySet();

        if(booksByFilter.contains("publisher")){
            for (String publisherName : filter.get("publiser")){
                for (Book searchBook : ListOfBooks){
                    if(publisherName.equalsIgnoreCase(searchBook.getPublisher()))
                        booksByPublisher.add(searchBook);
                }
            }
        }
        if(booksByFilter.contains("category")){
            for (String category : filter.get("category")){
                List<Book> list = getBookListByCategory(category);
                booksByCategory.addAll(list);
            }
        }
        booksByCategory.retainAll(booksByPublisher);

        return booksByCategory;
    }
}