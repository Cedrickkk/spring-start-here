package org.spring.framework.sqch12ex3.services;

import org.spring.framework.sqch12ex3.models.Purchase;
import org.spring.framework.sqch12ex3.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    public Purchase store(Purchase purchase) {
        return purchaseRepository.store(purchase);
    }
}
