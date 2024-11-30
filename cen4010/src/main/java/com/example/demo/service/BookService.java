package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findBooksByIsbnAndAuthor(String isbn, String author) {
        if (isbn != null && author != null) {
            return bookRepository.findByIsbnAndAuthor(isbn, author);
        } else if (isbn != null) {
            return bookRepository.findByIsbn(isbn);
        } else if (author != null) {
            return bookRepository.findByAuthor(author);
        } else {
            return bookRepository.findAll();
        }
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public List<Book> getBooksByGenre(String genre) {
		return bookRepository.findByGenre(genre);
	}

	public List<Book> getTopSellers() {
		return bookRepository.findTopSellers().subList(0, Math.min(10, bookRepository.findTopSellers().size()));
	}

	public List<Book> getBooksByRatingAndHigher(Double rating) {
		if (rating < 0 || rating > 5) {
			throw new IllegalArgumentException("Rating must be between 0 and 5");
		}
		return bookRepository.findByRatingGreaterThanEqual(rating);
	}

}