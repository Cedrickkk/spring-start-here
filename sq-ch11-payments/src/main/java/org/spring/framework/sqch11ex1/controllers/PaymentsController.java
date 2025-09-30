package org.spring.framework.sqch11ex1.controllers;

import org.spring.framework.sqch11ex1.models.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsController {
    private final Logger logger = Logger.getLogger(PaymentsController.class.getName());

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(@RequestHeader String requestID, @RequestBody Payment payment) {
        logger.info("Received request with ID: " + requestID + "; Payment Amount: " + payment.getAmount());
        payment.setId(UUID.randomUUID().toString());
        logger.info("Respond with ID: " + payment.getId());
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestID)
                .body(payment);
    }
}
