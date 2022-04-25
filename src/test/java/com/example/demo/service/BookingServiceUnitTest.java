package com.example.demo.service;

import com.example.demo.UnitTestSupport;
import com.example.demo.dto.BookRequest;
import com.example.demo.models.Borrowed;
import com.example.demo.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;

public class BookingServiceUnitTest extends UnitTestSupport {
    private BookRepository bookRepository;
    private BorrowedService borrowedService;

    private BookService bookService;

    @BeforeEach
    void setUp(){
        bookRepository= Mockito.mock(BookRepository.class);
        borrowedService=Mockito.mock(BorrowedService.class);
        bookService=new BookService(bookRepository,borrowedService);
    }

    @Test
    void testGetAllBooksWithBookRequest_whenRequestExistInDB_shouldReturnListOfBookNames(){
        BookRequest bookRequest=createExistBookRequest();
        Borrowed borrowed=createBorrowed();

        Mockito.when(borrowedService.findAllBorroweds()).thenReturn(List.of(borrowed));

        List<String> result=bookService.getAllBooksWithBookRequest(bookRequest);
        assertEquals(result.size(),1);
        assertEquals(result.get(0),borrowed.getBook_name());
    }

    @Test
    void testGetAllBooksWithBookRequest_whenRequestNotExistInDB_shouldReturnEmptyList(){
        BookRequest bookRequest=createNotExistBookRequest();
        Borrowed borrowed=createBorrowed();

        Mockito.when(borrowedService.findAllBorroweds()).thenReturn(List.of(borrowed));

        List<String> result=bookService.getAllBooksWithBookRequest(bookRequest);
        assertEquals(result.size(),0);
    }
}
