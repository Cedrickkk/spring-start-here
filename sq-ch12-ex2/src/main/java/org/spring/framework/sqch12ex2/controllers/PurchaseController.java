package org.spring.framework.sqch12ex2.controllers;

import org.spring.framework.sqch12ex2.models.Purchase;
import org.spring.framework.sqch12ex2.repositories.PurchaseRepository;
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
    public ResponseEntity<List<Purchase>> getPurchaseList() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(purchaseRepository.findAll());
    }

    @PostMapping("/purchase")
    public ResponseEntity<Purchase> storePurchase(@RequestBody Purchase purchase) {
        Purchase _purchase = purchaseRepository.store(purchase);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(_purchase);
    }
}
