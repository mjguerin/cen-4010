package com.cen4010.api.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "books")
public class Book {
	@Id
	private String ISBN;
	private String bookName;
	private String bookDescription;
	private BigDecimal price;
	private String author;
	private String genre;
	private String publisher;
	private Integer yearPublished;
	private Integer copiesSold;

    // Getter and Setter methods
 
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
}