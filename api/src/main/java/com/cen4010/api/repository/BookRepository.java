//BookRepository.java

package com.cen4010.api.repository;

import com.cen4010.api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
	List<Book> findByGenre(String genre);
	
	@Query("SELECT b FROM Book b ORDER BY b.copiesSold DESC")
    List<Book> findTopSellers();
	
	@Query("SELECT b FROM Book b WHERE b.rating >= :rating ORDER BY b.rating DESC")
    List<Book> findByRatingGreaterThanEqual(@Param("rating") Double rating);
	
}