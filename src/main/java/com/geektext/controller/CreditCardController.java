package com.geektext.controller;

import com.geektext.model.CreditCard;
import com.geektext.model.User;
import com.geektext.service.CreditCardService;
import com.geektext.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/credit-cards")
public class CreditCardController {

    private final CreditCardService creditCardService;
    private final UserService userService;

    // Constructor-based Dependency Injection
    @Autowired
    public CreditCardController(CreditCardService creditCardService, UserService userService) {
        this.creditCardService = creditCardService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> addCreditCard(@RequestBody Map<String, Object> requestData) {
        // Extract user information
        Map<String, String> userMap = (Map<String, String>) requestData.get("user");
        String username = userMap.get("username");

        // Fetch the user from the database
        User user = userService.getUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Create and populate the CreditCard object
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber((String) requestData.get("cardNumber"));
        creditCard.setExpirationDate((String) requestData.get("expirationDate"));
        creditCard.setCardHolderName((String) requestData.get("cardHolderName"));
        creditCard.setUser(user);

        // Save the credit card to the database
        creditCardService.addCreditCard(creditCard);

        return ResponseEntity.ok().build();
    }
}
