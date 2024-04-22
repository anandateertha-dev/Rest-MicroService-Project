package com.microservice.ecommerce.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.ecommerce.Models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel,UUID> {
    
}
