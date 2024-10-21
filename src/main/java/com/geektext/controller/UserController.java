package com.geektext.controller;

import com.geektext.model.User;
import com.geektext.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
