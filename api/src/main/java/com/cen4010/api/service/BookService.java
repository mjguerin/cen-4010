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
}