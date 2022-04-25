package com.example.demo.controller;

import com.example.demo.dto.BookRequest;
import com.example.demo.models.Book;
import com.example.demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public ResponseEntity<List<String>> getAllBooksBorrowedByAGivenUserAndDateRange(@RequestBody BookRequest bookRequest){
        return new ResponseEntity<>(
                bookService.getAllBooksWithBookRequest(bookRequest),
                HttpStatus.OK
        );
    }
}
