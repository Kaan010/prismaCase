package com.example.demo.controller;

import com.example.demo.IntegrationTestSupport;
import com.example.demo.dto.BookRequest;
import com.example.demo.models.Borrowed;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookControllerIT extends IntegrationTestSupport {

    @Test
    public void testGetAllBooksBorrowedByAGivenUserAndDateRange_RequestExistInDB_ShouldReturnListOfBookNames() throws Exception {
        borrowedRepository.saveAllAndFlush(getTwoBorrowed());
        BookRequest bookRequest = createExistBookRequest();

        this.mockMvc.perform(get("/v1/book/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writer().withDefaultPrettyPrinter().writeValueAsString(bookRequest)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.*", hasSize(2)));
    }

    @Test
    public void testGetAllBooksBorrowedByAGivenUserAndDateRange_RequestNotExistInDB_ShouldReturnEmptyList() throws Exception {
        BookRequest bookRequest = createExistBookRequest();

        this.mockMvc.perform(get("/v1/book/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writer().withDefaultPrettyPrinter().writeValueAsString(bookRequest)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.*", hasSize(0)));
    }
}
