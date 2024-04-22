package com.microservice.ecommerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.ecommerce.Models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

}
