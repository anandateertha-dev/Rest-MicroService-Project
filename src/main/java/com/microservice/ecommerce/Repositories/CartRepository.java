package com.microservice.ecommerce.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.ecommerce.Models.Cart;
import java.util.List;


public interface CartRepository extends JpaRepository<Cart,UUID>{
    List<Cart> findByUserId(int userId);
}
