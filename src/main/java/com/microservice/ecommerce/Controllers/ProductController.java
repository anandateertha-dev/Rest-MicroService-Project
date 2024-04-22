package com.microservice.ecommerce.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ecommerce.Models.ProductModel;
import com.microservice.ecommerce.Models.ResponseMessage;
import com.microservice.ecommerce.Repositories.ProductRepository;
import com.microservice.ecommerce.Services.ProductSerivce;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductSerivce productSerivce;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("addproduct")
    public ResponseEntity<ResponseMessage> addProduct(@RequestBody ProductModel product)
    {
        
        return productSerivce.addProductService(product);
    }

    @GetMapping("getallproducts")
    public List<ProductModel> getallproducts()
    {
        return productRepository.findAll();
    }
    
}
