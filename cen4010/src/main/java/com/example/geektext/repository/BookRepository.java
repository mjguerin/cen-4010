package com.example.geektext.repository;

import com.example.geektext.model.Book;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByIsbnAndAuthor(String isbn, String author);
    List<Book> findByIsbn(String isbn);
    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);
    
    @Query("SELECT b FROM Book b ORDER BY b.copiesSold DESC")
    List<Book> findTopSellers();
    
    @Query("SELECT b FROM Book b WHERE b.rating >= :rating ORDER BY b.rating DESC")
    List<Book> findByRatingGreaterThanEqual(@Param("rating") Double rating);

    @Modifying
    @Query("UPDATE Book b SET b.price = ROUND(b.price * (1 - :discountPercent/100),2) WHERE b.publisher = :publisher")
    int applyPublisherDiscount(@Param("discountPercent") Double discountPercent, 
                              @Param("publisher") String publisher);
    
}