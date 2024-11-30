package com.example.demo.service;

import com.example.demo.model.CreditCard;
import com.example.demo.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    public void addCreditCard(CreditCard creditCard) {
        creditCardRepository.save(creditCard);
    }
}