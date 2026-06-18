package com.retailtech.api_productos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public record Product(@Id int id, String name, double price, int stock) {
}