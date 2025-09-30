package org.spring.framework.sqch11ex2.controllers;

import org.spring.framework.sqch11ex2.models.Payment;
import org.spring.framework.sqch11ex2.proxies.PaymentsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public Payment createPayment(@RequestBody Payment payment) {
        Payment _payment = paymentsProxy.createPayment(payment);
        logger.info("Received from payment service " + _payment);
        return _payment;
    }
}
