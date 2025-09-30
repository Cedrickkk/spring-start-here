package org.spring.framework.sqch10ex6.services;

import org.springframework.stereotype.Service;
import org.spring.framework.sqch10ex6.exceptions.NotEnoughMoneyException;
import org.spring.framework.sqch10ex6.models.PaymentDetails;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException("Insufficient funds.");
    }
}
