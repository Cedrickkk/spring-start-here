package org.spring.framework.sqch12ex1.controllers;

import org.spring.framework.sqch12ex1.models.Purchase;
import org.spring.framework.sqch12ex1.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping("/purchase")
    public ResponseEntity<List<Purchase>> getPurchase() {
        List<Purchase> purchaseList = purchaseRepository.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(purchaseList);
    }

    @PostMapping("/purchase")
    public ResponseEntity<Purchase> purchase(@RequestBody Purchase purchase) {
        Purchase _purchase = purchaseRepository.store(purchase);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(_purchase);
    }
}
