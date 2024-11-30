package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Finds books by both ISBN and Author.
     *
     * @param isbn   The ISBN of the book.
     * @param author The author of the book.
     * @return A list of books matching the ISBN and Author.
     */
    List<Book> findByIsbnAndAuthor(String isbn, String author);

    /**
     * Finds books by ISBN.
     *
     * @param isbn The ISBN of the book.
     * @return A list of books matching the ISBN.
     */
    List<Book> findByIsbn(String isbn);

    /**
     * Finds books by Author.
     *
     * @param author The author of the book.
     * @return A list of books matching the Author.
     */
    List<Book> findByAuthor(String author);

    /**
     * Finds books by Genre.
     *
     * @param genre The genre of the books.
     * @return A list of books matching the Genre.
     */
    List<Book> findByGenre(String genre);

    /**
     * Retrieves the top-selling books ordered by copies sold in descending order.
     * Limits the result to the top 10 sellers.
     *
     * @return A list of top-selling books.
     */
    @Query("SELECT b FROM Book b ORDER BY b.copiesSold DESC")
    List<Book> findTopSellers();

    /**
     * Finds books with a rating greater than or equal to the specified value.
     *
     * @param rating The minimum rating threshold.
     * @return A list of books meeting the rating criteria.
     */
    @Query("SELECT b FROM Book b WHERE b.rating >= :rating ORDER BY b.rating DESC")
    List<Book> findByRatingGreaterThanEqual(@Param("rating") Double rating);

}
