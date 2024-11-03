//BookService.java
package com.cen4010.api.service;

import com.cen4010.api.model.Book;
import com.cen4010.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
 private final BookRepository bookRepository;

 @Autowired
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }

 public List<Book> getBooksByGenre(String genre) {
     return bookRepository.findByGenre(genre);
 }
 
 public List<Book> getTopSellers() {
	 return bookRepository.findTopSellers().subList(0, Math.min(10, bookRepository.findTopSellers().size()));
 }
 
 public List<Book> getBooksByRatingAndHigher(Double rating) {
     if (rating < 0 || rating > 5) {
         throw new IllegalArgumentException("Rating must be between 0 and 5");
     }
     return bookRepository.findByRatingGreaterThanEqual(rating);
 }
 
}