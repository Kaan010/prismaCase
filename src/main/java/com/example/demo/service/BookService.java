package com.example.demo.service;


import com.example.demo.dto.BookRequest;
import com.example.demo.models.Book;
import com.example.demo.models.Borrowed;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BorrowedService borrowedService;

    public BookService(BookRepository bookRepository, BorrowedService borrowedService) {
        this.bookRepository = bookRepository;
        this.borrowedService = borrowedService;
    }

    public List<String> getAllBooksWithBookRequest(BookRequest bookRequest) {
        return borrowedService.findAllBorroweds()
                .stream()
                .filter(borrowed->borrowed.getBorrower_Name().equals(bookRequest.getUserName()))
                .filter(borrowed->borrowed.getBorrowedFrom().before(bookRequest.getBorrowedFrom()))
                .filter(borrowed->borrowed.getBorrowedTo().after(bookRequest.getBorrowedTo()))
                .map(Borrowed::getBook_name)
                .collect(Collectors.toList());
    }
}
