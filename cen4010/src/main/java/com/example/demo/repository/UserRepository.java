package com.geektext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.geektext.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    // Method to delete a user by username
    void deleteByUsername(String username);

}