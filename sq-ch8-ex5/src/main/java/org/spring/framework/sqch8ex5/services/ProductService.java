package org.spring.framework.sqch8ex5.services;

import org.springframework.stereotype.Service;
import org.spring.framework.sqch8ex5.models.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> findAll() {
        return products;
    }
}
