package com.cen4010.api.repository;

import com.cen4010.api.model.RateComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RateCommentRepository extends JpaRepository<RateComment, Integer> 
{
	List<RateComment> findByBookId(String bookId);
    
    // Check if a user has already rated and commented on a specific book
    Optional<RateComment> findByUserIdAndBookId(int userId, String bookId);
    
    // Calculate average using JPA query
    @Query("SELECT AVG(r.rating) FROM RateComment r WHERE r.bookId = ?1")
    Double findAvgRating(String bookId);
}
