package com.workintech.jpa.onetomany.controller;

import com.workintech.jpa.onetomany.entity.Book;
import com.workintech.jpa.onetomany.entity.Category;
import com.workintech.jpa.onetomany.service.BookService;
import com.workintech.jpa.onetomany.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;
    private CategoryService categoryService;
    @Autowired
    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("/{categoryId}")
    public Book save(@RequestBody Book book, @PathVariable int categoryId){
        Category category = categoryService.findById(categoryId);
        if(category != null){
            book.setCategory(category);
            bookService.save(book);
        }
        return null;

    }
}
