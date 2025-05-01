package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {


    List<Book> getAllBooks();

    Optional<Book> saveBook(Book book);

    Optional<Book> updateBook(int bookId, Book book);

    boolean deleteBook(int bookId);


}
