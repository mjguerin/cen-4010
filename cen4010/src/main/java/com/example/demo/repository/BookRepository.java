package com.example.demo.repository;

import com.example.demo.model.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByIsbnAndAuthor(String isbn, String author);
    List<Book> findByIsbn(String isbn);
    List<Book> findByAuthor(String author);

}





