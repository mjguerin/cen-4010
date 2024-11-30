package com.geektext.service;

import com.geektext.model.CreditCard;
import com.geektext.repository.CreditCardRepository;
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