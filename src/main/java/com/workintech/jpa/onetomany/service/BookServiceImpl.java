package com.workintech.jpa.onetomany.service;

import com.workintech.jpa.onetomany.entity.Book;
import com.workintech.jpa.onetomany.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        Optional<Book>book = bookRepository.findById(id);
        if(book.isPresent()){
            return book.get();
        }
        return null;

    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);

    }
}
