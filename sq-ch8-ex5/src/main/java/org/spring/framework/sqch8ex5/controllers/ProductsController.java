package org.spring.framework.sqch8ex5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.spring.framework.sqch8ex5.models.Product;
import org.spring.framework.sqch8ex5.services.ProductService;

@Controller
public class ProductsController {
    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products.html";
    }

    @PostMapping(path = "/products")
    public String addProduct(@RequestParam String name, @RequestParam double price, Model model) {
        productService.addProduct(new Product(name, price));
        model.addAttribute("products", productService.findAll());
        return "products.html";
    }
}
