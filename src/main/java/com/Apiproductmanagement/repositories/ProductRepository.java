package com.Apiproductmanagement.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.Apiproductmanagement.domain.product.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
