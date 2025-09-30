package org.spring.framework.sqch1ex5.services;

import org.springframework.stereotype.Service;
import org.spring.framework.sqch1ex5.exceptions.NotEnoughMoneyException;
import org.spring.framework.sqch1ex5.models.PaymentDetails;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException("Insufficient funds.");
    }
}
