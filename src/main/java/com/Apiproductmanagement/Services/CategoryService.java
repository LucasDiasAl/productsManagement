package com.Apiproductmanagement.Services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Apiproductmanagement.domain.category.Category;
import com.Apiproductmanagement.domain.category.CategoryDTO;
import com.Apiproductmanagement.domain.category.exceptions.CategoryNotFound;
import com.Apiproductmanagement.repositories.CategoryRepository;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category create(CategoryDTO categoryData) {
        Category newCategory = new Category(categoryData);
        this.repository.save(newCategory);
        return newCategory;
    }

    public List<Category> getAllCategories() {
        return this.repository.findAll();
    }

    public Category updateCategory(String id, CategoryDTO categoryData) {
        Category category = this.repository.findById(id).orElseThrow(CategoryNotFound::new);
        if (!categoryData.title().isEmpty())
            category.setTitle(categoryData.title());
        if (!categoryData.description().isEmpty())
            category.setDescription(categoryData.description());
        this.repository.save(category);
        return category;
    }

    public void deleteCategory(String id) {
        Category category = this.repository.findById(id).orElseThrow(CategoryNotFound::new);
        this.repository.delete(category);
    }
}
