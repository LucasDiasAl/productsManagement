package com.Apiproductmanagement.Services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Apiproductmanagement.domain.category.Category;
import com.Apiproductmanagement.domain.category.exceptions.CategoryNotFound;
import com.Apiproductmanagement.domain.product.Product;
import com.Apiproductmanagement.domain.product.ProductDTO;
import com.Apiproductmanagement.domain.product.exceptions.ProductNotFound;
import com.Apiproductmanagement.repositories.ProductRepository;

@Service
public class ProductService {
    private CategoryService categoryService;
    private ProductRepository repository;

    public ProductService(CategoryService categoryService, ProductRepository repository) {
        this.repository = repository;
        this.categoryService = categoryService;
    }

    public Product create(ProductDTO productData) {
        Category category = categoryService.getById(productData.categoryId())
                .orElseThrow(CategoryNotFound::new);
        Product newProduct = new Product(productData);
        newProduct.setCategory(category);
        this.repository.save(newProduct);
        return newProduct;
    }

    public List<Product> getAllProducts() {
        return this.repository.findAll();
    }

    public Product updateProduct(String id, ProductDTO productData) {
        Product product = this.repository.findById(id).orElseThrow(ProductNotFound::new);
        if (!productData.title().isEmpty())
            product.setTitle(productData.title());
        if (!productData.description().isEmpty())
            product.setDescription(productData.description());
        if (productData.price() != null)
            product.setPrice(productData.price());
        categoryService.getById(productData.categoryId()).ifPresent(product::setCategory);
        this.repository.save(product);
        return product;
    }

    public void deleteProduct(String id) {
        Product product = this.repository.findById(id).orElseThrow(ProductNotFound::new);
        this.repository.delete(product);
    }
}
