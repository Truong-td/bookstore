package com.truongtd.bookstore.api.controller;

import com.truongtd.bookstore.api.response.ApiResponse;
import com.truongtd.bookstore.api.response.SuccessResponse;
import com.truongtd.bookstore.domain.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @GetMapping
    public ApiResponse getBooks() {

        Book book = Book.builder()
                .name("truongtd")
                .title("Help self")
                .build();
        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book);
        return new SuccessResponse(books);
    }
}
