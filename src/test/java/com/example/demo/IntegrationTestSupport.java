package com.example.demo;

import com.example.demo.dto.BookRequest;
import com.example.demo.models.Borrowed;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.BorrowedRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookService;
import com.example.demo.service.BorrowedService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
@DirtiesContext
@AutoConfigureMockMvc //fake tomcat
public class IntegrationTestSupport {
    public final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public BookService bookService;

    @Autowired
    public UserService userService;

    @Autowired
    public BorrowedService borrowedService;

    @Autowired
    public BookRepository bookRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public BorrowedRepository borrowedRepository;

    @BeforeEach
    public void setup() {
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        borrowedRepository.deleteAll();
    }

    public List<Borrowed> getTwoBorrowed() {
        return List.of(
                new Borrowed(
                        "1",
                        "testName",
                        "testBorrowedBookName1",
                        DateParserUtil.parseDate("2000-01-01"),
                        DateParserUtil.parseDate("2000-10-01")
                ), new Borrowed(
                        "2",
                        "testName",
                        "testBorrowedBookName2",
                        DateParserUtil.parseDate("2000-01-01"),
                        DateParserUtil.parseDate("2000-10-01")
                ));
    }

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
}
