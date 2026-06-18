package com.retailtech.api_productos.controller;

import com.retailtech.api_productos.model.Product;
import com.retailtech.api_productos.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository repository;

    // Inyección de dependencias recomendada
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Flux<Product> getAll() {
        return repository.findAll();
    }
}
