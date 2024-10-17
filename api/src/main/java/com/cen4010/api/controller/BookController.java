//BookController.java
package com.cen4010.api.controller;

import com.cen4010.api.model.Book;
import com.cen4010.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
 private final BookService bookService;

 @Autowired
 public BookController(BookService bookService) {
     this.bookService = bookService;
 }

 @GetMapping
 public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam String genre) {
     List<Book> books = bookService.getBooksByGenre(genre);
     return ResponseEntity.ok(books);
 }
 
 @GetMapping("/top-sellers")
 public ResponseEntity<List<Book>> getTopSellers() {
     List<Book> topSellers = bookService.getTopSellers();
     return ResponseEntity.ok(topSellers);
 }
 
}
