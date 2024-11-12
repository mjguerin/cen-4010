package com.library.ShoppingCart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.ShoppingCart.entity.ShoppingCart;
import com.library.ShoppingCart.repository.ShoppingCartRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    // Get subtotal price of all books in the cart for a user
    public Double getSubtotal(Long userId) {
        List<ShoppingCart> cartItems = shoppingCartRepository.findByUserId(userId);
        return cartItems.stream()
                        .mapToDouble(ShoppingCart::getBookCost)
                        .sum();
    }

    // Add a book to the user's cart
    public void addBookToCart(Long userId, String firstName, String lastName, Long bookId, String bookName, Double bookCost) {
        ShoppingCart cartItem = new ShoppingCart();
        cartItem.setUserId(userId);
        cartItem.setFirstName(firstName);
        cartItem.setLastName(lastName);
        cartItem.setBookId(bookId);
        cartItem.setBookName(bookName);
        cartItem.setBookCost(bookCost);
        shoppingCartRepository.save(cartItem);
    }

    // Retrieve list of books in the user's cart
    public List<ShoppingCart> getBooksInCart(Long userId) {
        return shoppingCartRepository.findByUserId(userId);
    }

    // Remove a book from the user's cart
    public void removeBookFromCart(Long userId, Long bookId) {
        shoppingCartRepository.deleteByUserIdAndBookId(userId, bookId);
    }
}