package com.example.demo.repositorary;

import com.example.demo.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository {

    List<Book> getAllBooks();

    Book saveBook(Book book);

    Book updateBook(int bookId, Book book);

    boolean deleteBook(int bookId);




}
