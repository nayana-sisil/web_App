package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    //read
    @GetMapping("/books")
    public List<Book> getListOfBooks() {
        return bookService.getAllBooks();
    }

//create

    @PostMapping("/books")
    public Optional<Book> saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

//update
    @PutMapping("/books/{bookId}")
    public Optional<Book> updateBook(@RequestBody Book book, @PathVariable int bookId) {
        return bookService.updateBook(bookId,book);
    }


    //delete
    @DeleteMapping("books/{bookId}")
    public boolean deleteBook(@PathVariable int bookId) {
        return bookService.deleteBook(bookId);
    }






}
