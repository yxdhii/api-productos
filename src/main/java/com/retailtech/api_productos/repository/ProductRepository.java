package com.retailtech.api_productos.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.retailtech.api_productos.model.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}

