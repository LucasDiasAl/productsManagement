package com.Apiproductmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories

public class ApiProductManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiProductManagementApplication.class, args);
    }
}
