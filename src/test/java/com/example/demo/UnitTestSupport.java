package com.example.demo;

import com.example.demo.dto.BookRequest;
import com.example.demo.models.Book;
import com.example.demo.models.Borrowed;

public class UnitTestSupport {

    public BookRequest createExistBookRequest() {
        return new BookRequest(
                "testName",
                DateParserUtil.parseDate("2000-02-01"),
                DateParserUtil.parseDate("2000-09-01")
        );
    }

    public BookRequest createNotExistBookRequest() {
        return new BookRequest(
                "testName",
                DateParserUtil.parseDate("2000-01-01"),
                DateParserUtil.parseDate("2000-11-01")
        );
    }

    public Borrowed createBorrowed() {
        return new Borrowed(
                "1",
                "testName",
                "testBorrowedBookName",
                DateParserUtil.parseDate("2000-01-01"),
                DateParserUtil.parseDate("2000-10-01")
        );
    }

    public Book createBook() {
        return new Book(
                "1",
                "testBookTitle",
                "testBookAuthor",
                "testBookGenre",
                "testBookPublisher"
        );
    }
}
