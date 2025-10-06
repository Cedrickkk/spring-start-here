package org.spring.framework.sqch12ex3.controllers;

import org.spring.framework.sqch12ex3.models.Purchase;
import org.spring.framework.sqch12ex3.services.PurchaseService;
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
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/purchase")
    public ResponseEntity<List<Purchase>> findAll() {
        List<Purchase> purchaseList = purchaseService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(purchaseList);
    }

    @PostMapping("/purchase")
    public ResponseEntity<Purchase> store(@RequestBody Purchase purchase) {
        Purchase _purchase = purchaseService.store(purchase);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(_purchase);
    }
}
