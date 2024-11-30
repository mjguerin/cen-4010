package com.geektext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.geektext.model.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}