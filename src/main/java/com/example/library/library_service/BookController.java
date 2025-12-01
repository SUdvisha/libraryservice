package com.example.library.library_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("addOne")
    public ResponseEntity<Book> addOneBook(@RequestBody Book book){
        book = bookService.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Book>> findAllBooks(){
        var list = bookService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("findById")
    public ResponseEntity<Book> findBookById(@RequestParam Long bookId){
        var book = bookService.findById(bookId);
        return new ResponseEntity<>(book.orElse(null),HttpStatus.OK);
    }

    @DeleteMapping("deleteById")
    public ResponseEntity<Book> deleteBookById(@RequestParam Long bookId){
        bookService.deleteById(bookId);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        book = bookService.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
