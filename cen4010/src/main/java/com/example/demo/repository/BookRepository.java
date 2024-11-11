//BookRepository.java

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
	List<Book> findByGenre(String genre);
	
	@Query("SELECT b FROM Book b ORDER BY b.copiesSold DESC")
    List<Book> findTopSellers();
	
	@Query("SELECT b FROM Book b WHERE b.rating >= :rating ORDER BY b.rating DESC")
    List<Book> findByRatingGreaterThanEqual(@Param("rating") Double rating);
	
}