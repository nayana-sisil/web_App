package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repositorary.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public Optional<Book> saveBook(Book book) {

        Book savedBook = bookRepository.saveBook(book);

        if (savedBook != null) {
            return Optional.of(savedBook);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Book> updateBook(int bookId, Book book) {
        Book updatedBook = bookRepository.updateBook(bookId,book);

        if (updatedBook != null) {
            return Optional.of(updatedBook);
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteBook(int bookId) {
        return bookRepository.deleteBook(bookId);
    }
}
