package org.spring.framework.sqch1ex5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spring.framework.sqch1ex5.exceptions.NotEnoughMoneyException;
import org.spring.framework.sqch1ex5.models.ErrorDetails;
import org.spring.framework.sqch1ex5.models.PaymentDetails;
import org.spring.framework.sqch1ex5.services.PaymentService;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try {
            PaymentDetails paymentDetails = paymentService.processPayment();
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        } catch (NotEnoughMoneyException ex) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage(ex.getMessage());
            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
        }
    }
}
