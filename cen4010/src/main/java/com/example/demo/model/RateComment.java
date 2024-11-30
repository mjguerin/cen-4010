package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rate_comment")
public class RateComment 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int raCoId;
	
    @Column(name = "user_id")
    private int userId;
    
    @Column(name = "isbn")
    private String bookId;
    
    private Float rating;
    private String comment;
    
    @Column(name = "date")
    private LocalDateTime date;

    
    //Get
    public int getRaCoId() 
    {
    	return raCoId;
    }
    public int getUserId() 
    {
    	return userId;
    }
    public String getBookId() 
    {
        return bookId;
    }
    public Float getRating() 
    {
        return rating;
    }
    public String getComment() 
    {
        return comment;
    }
    public LocalDateTime getDate() 
    {
        return date;
    }
      
    
    //Set
    public void setRaCoId(int raCoId) 
    {
    	this.raCoId = raCoId;
    }
    public void setUserId(int userId) 
    {
    	this.userId = userId;
    }
    public void setBookId(String bookId) 
    {
        this.bookId = bookId;
    }
    public void setRating(Float rating) 
    {
        this.rating = rating;
        this.date = LocalDateTime.now();
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
        this.date = LocalDateTime.now();
    }
    public void setDate(LocalDateTime  date) 
    {
        this.date = date;
    }
    
}
