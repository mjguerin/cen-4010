package com.cen4010.api.controller;

import com.cen4010.api.model.RateComment;
import com.cen4010.api.service.RateCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rate_comment")
public class RateCommentController 
{
    @Autowired
    private RateCommentService rateCommentService;
    
    // Get all rating and comments for a book
    @GetMapping("/{bookId}")
    public List<RateComment> getRateComments(@PathVariable String bookId) 
    {
        return rateCommentService.getRateComments(bookId);
    }

    // Average rating for a book
    @GetMapping("/{bookId}/avg")
    public ResponseEntity<String> getAvgRating(@PathVariable String bookId) 
    {
        Double avgRating = rateCommentService.getAvgRating(bookId);
        
        if (avgRating == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No ratings found for bookId " + bookId + ".");
        }

        String avgRatingMsg = String.format("The average rating for ISBN %s is %.2f.", bookId, avgRating);
        return ResponseEntity.ok(avgRatingMsg);
    }

    // Create a book rating and comment
    @PostMapping("/ratecomment")
    public ResponseEntity<String> createRating(@RequestParam int userId, @RequestParam String bookId, @RequestParam Float rating, @RequestParam String comment) 
    {
        String respMsg = rateCommentService.createRateComment(userId, bookId, rating, comment);
        HttpStatus status;

        if (respMsg.contains("successfully")) 
        {
            status = HttpStatus.CREATED;
        } 
        else 
        {
            status = HttpStatus.CONFLICT;
        }
        return ResponseEntity.status(status).body(respMsg);
    }

  
}
