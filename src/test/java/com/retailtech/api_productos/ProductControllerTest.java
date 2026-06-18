package com.retailtech.api_productos;

import com.retailtech.api_productos.controller.ProductController;
import com.retailtech.api_productos.model.Product;
import com.retailtech.api_productos.repository.ProductRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webflux.test.autoconfigure.WebFluxTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

@WebFluxTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private WebTestClient webClient;
    @MockitoBean
    private ProductRepository repository;

@Test
void testGetAllProducts() {
// ATENCIÓN: Si usaste MongoDB, cambia el "1" (Integer) por"abc-123" (String)
Product mockProduct = new Product(1, "Laptop", 1500.0, 10);
// Comportamiento simulado (Mock) de la Base de Datos
Mockito.when(repository.findAll()).thenReturn(Flux.just(mockProduct));
// Ejecución de la llamada a la API
webClient.get().uri("/api/products")
.exchange()
.expectStatus().isOk()
.expectBodyList(Product.class).hasSize(1);
}
}