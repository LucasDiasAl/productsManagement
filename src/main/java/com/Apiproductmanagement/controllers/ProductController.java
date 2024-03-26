package com.Apiproductmanagement.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Apiproductmanagement.Services.ProductService;
import com.Apiproductmanagement.domain.product.Product;
import com.Apiproductmanagement.domain.product.ProductDTO;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO productData) {
        Product createdProduct = this.service.create(productData);
        return ResponseEntity.ok().body(createdProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = this.service.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathParam("id") String id,
            @RequestBody ProductDTO productData) {
        Product updatedProduct = this.service.updateProduct(id, productData);
        return ResponseEntity.status(204).body(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> update(@PathParam("id") String id) {
        this.service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
