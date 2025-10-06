package org.spring.framework.sqch11ex1.controllers;

import org.spring.framework.sqch11ex1.models.Payment;
import org.spring.framework.sqch11ex1.proxies.PaymentsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsController {
    private final Logger logger = Logger.getLogger(PaymentsController.class.getName());
    private final PaymentsProxy paymentsProxy;

    @Autowired
    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        ResponseEntity<Payment> _payment = paymentsProxy.createPayment(requestId, payment);
        logger.info("Payment Created " + _payment.getBody());
        return _payment;
    }
}
