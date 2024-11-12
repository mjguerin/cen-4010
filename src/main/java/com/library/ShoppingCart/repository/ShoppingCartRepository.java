package com.library.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.ShoppingCart.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    // Find all items in the cart for a specific user
    List<ShoppingCart> findByUserId(Long userId);

    // Delete a specific book from the user's cart
    void deleteByUserIdAndBookId(Long userId, Long bookId);
}