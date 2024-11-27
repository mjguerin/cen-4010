package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseEntity<List<Book>> findBooksByIsbnAndAuthor(
			@RequestParam(name = "isbn", required = false) String isbn,
			@RequestParam(name = "author", required = false) String author) {

		try {
			List<Book> books = bookService.findBooksByIsbnAndAuthor(isbn, author);
			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (Exception e) {
			System.err.println("Error retrieving books: " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Create a new book
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		try {
			Book createdBook = bookService.createBook(book);
			return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
		} catch (Exception e) {
			System.err.println("Error creating book: " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Get a book by ID
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		try {
			Book book = bookService.getBookById(id);
			if (book != null) {
				return new ResponseEntity<>(book, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.err.println("Error retrieving book by ID: " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam String genre) {
		List<Book> books = bookService.getBooksByGenre(genre);
		return ResponseEntity.ok(books);
	}

	@GetMapping("/top-sellers")
	public ResponseEntity<List<Book>> getTopSellers() {
		List<Book> topSellers = bookService.getTopSellers();
		return ResponseEntity.ok(topSellers);
	}

	@GetMapping("/by-rating")
	public ResponseEntity<?> getBooksByRatingAndHigher(@RequestParam Double rating) {
		try {
			List<Book> books = bookService.getBooksByRatingAndHigher(rating);
			return ResponseEntity.ok(books);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}