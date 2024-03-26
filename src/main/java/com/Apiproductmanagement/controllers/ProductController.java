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
import com.Apiproductmanagement.Services.CategoryService;
import com.Apiproductmanagement.domain.category.Category;
import com.Apiproductmanagement.domain.category.CategoryDTO;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/product")
public class ProductController {
    private CategoryService service;

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDTO categoryData) {
        Category createdCategory = this.service.create(categoryData);
        return ResponseEntity.ok().body(createdCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = this.service.getAllCategories();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathParam("id") String id,
            @RequestBody CategoryDTO categoryData) {
        Category updatedCategory = this.service.updateCategory(id, categoryData);
        return ResponseEntity.status(204).body(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> update(@PathParam("id") String id) {
        this.service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
