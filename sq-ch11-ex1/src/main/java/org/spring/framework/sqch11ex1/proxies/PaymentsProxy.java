package org.spring.framework.sqch11ex1.proxies;

import org.spring.framework.sqch11ex1.models.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payments", url = "${name.service.url}")
public interface PaymentsProxy {
    @PostMapping("/payment")
    ResponseEntity<Payment> createPayment(@RequestHeader String requestId, @RequestBody Payment payment);
}
