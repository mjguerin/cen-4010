//BookController.java
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

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
 
 @GetMapping("/by-rating")
 public ResponseEntity<?> getBooksByRatingAndHigher(
         @RequestParam Double rating) {
     try {
         List<Book> books = bookService.getBooksByRatingAndHigher(rating);
         return ResponseEntity.ok(books);
     } catch (IllegalArgumentException e) {
         return ResponseEntity.badRequest().body(e.getMessage());
     }
 }
 
}
