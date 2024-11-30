package com.example.demo.service;

import com.example.demo.model.RateComment;
import com.example.demo.repository.RateCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RateCommentService 
{
    @Autowired
    private RateCommentRepository rateCommentRepository;

    // Comments
    public List<RateComment> getRateComments(String bookId) 
    {
        List<RateComment> comments = rateCommentRepository.findByBookId(bookId);     
        comments.forEach(comment -> 
        {
            if (comment.getComment() == null || comment.getComment().isEmpty()) 
            {
                comment.setComment("No comment");
            }
        });
        
        return comments;
    }
    
    // Average rating
    public Double getAvgRating(String bookId) 
    {     
        return rateCommentRepository.findAvgRating(bookId);
    }
    
    // New ratings/comments table
    public String createRateComment(int userId, String bookId, Float rating, String comment) 
    {
        Optional<RateComment> prevComment = rateCommentRepository.findByUserIdAndBookId(userId, bookId);
        
        if (prevComment.isPresent()) 
        {
            return "User " + userId + ", you have already rated and commented on this book.";
        }

        RateComment rateComment = new RateComment();
        rateComment.setUserId(userId);
        rateComment.setBookId(bookId);
        rateComment.setRating(rating);
        rateComment.setComment(comment);
        rateCommentRepository.save(rateComment);
        
        return "Your rating/comment was successfully added.";
    }
}
