package com.Apiproductmanagement.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.Apiproductmanagement.domain.category.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
