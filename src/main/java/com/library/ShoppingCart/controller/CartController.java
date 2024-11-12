package com.library.ShoppingCart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.library.ShoppingCart.entity.ShoppingCart;
import com.library.ShoppingCart.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // Get subtotal for a user's cart
    @GetMapping("/subtotal/{userId}")
    public Double getCartSubtotal(@PathVariable Long userId) {
        return cartService.getSubtotal(userId);
    }

    // Add a book to the cart
    @PostMapping("/add")
    public void addBookToCart(@RequestParam Long userId, 
                              @RequestParam String firstName, 
                              @RequestParam String lastName, 
                              @RequestParam Long bookId, 
                              @RequestParam String bookName, 
                              @RequestParam Double bookCost) {
        cartService.addBookToCart(userId, firstName, lastName, bookId, bookName, bookCost);
    }

    // Get list of books in user's cart
    @GetMapping("/books/{userId}")
    public List<ShoppingCart> getBooksInCart(@PathVariable Long userId) {
        return cartService.getBooksInCart(userId);
    }

    // Remove a book from the user's cart
    @DeleteMapping("/remove")
    public void removeBookFromCart(@RequestParam Long userId, @RequestParam Long bookId) {
        cartService.removeBookFromCart(userId, bookId);
    }
}