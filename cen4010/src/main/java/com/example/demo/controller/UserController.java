package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("/{username}")
    public Optional<User> getUser(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PutMapping("/{username}")
    public void updateUser(@PathVariable String username, @RequestBody User updatedUser) {
        Optional<User> user = userService.getUserByUsername(username);
        user.ifPresent(existingUser -> {
            existingUser.setName(updatedUser.getName());
            existingUser.setAddress(updatedUser.getAddress());
            userService.updateUser(existingUser);
        });
    }
    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        Optional<User> userOpt = userService.getUserByUsername(username);
        if (userOpt.isPresent()) {
            userService.deleteUserByUsername(username);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}