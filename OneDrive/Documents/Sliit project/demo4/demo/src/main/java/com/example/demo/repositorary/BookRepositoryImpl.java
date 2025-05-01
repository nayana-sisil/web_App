package com.example.demo.repositorary;

import com.example.demo.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {


    @Override
    public List<Book> getAllBooks() {
        File file = new File("Books.txt");
        ObjectMapper objectMapper = new ObjectMapper();

        List<Book> books = new ArrayList<>();

        try {
            if (file.exists() && file.length() > 0) {
                books = objectMapper.readValue(file,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Book.class));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public Book saveBook(Book book) {
        List<Book> books = getAllBooks();
        books.add(book);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File("Books.txt"), books);
            return book;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book updateBook(int bookId, Book book) {
        List<Book> books = getAllBooks();
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                b.setBookId(book.getBookId());
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setPublicationDate(book.getPublicationDate());

                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    objectMapper.writeValue(new File("Books.txt"), books);
                    return b;
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /*
    @Override
    public boolean deleteBook(int bookId) {
        List<Book> books = getAllBooks();
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                books.remove(b);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("Books.txt"), books);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

     */
    @Override
    public boolean deleteBook(int bookId) {
        List<Book> books = getAllBooks();
        Book toRemove = null;

        for (Book b : books) {
            if (b.getBookId() == bookId) {
                toRemove = b;
                break;
            }
        }

        if (toRemove != null) {
            books.remove(toRemove);

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writeValue(new File("Books.txt"), books);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

}
