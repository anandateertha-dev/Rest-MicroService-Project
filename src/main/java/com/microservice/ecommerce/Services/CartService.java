package com.microservice.ecommerce.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservice.ecommerce.Models.Cart;
import com.microservice.ecommerce.Models.ResponseMessage;
import com.microservice.ecommerce.Repositories.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ResponseMessage responseMessage;

    public ResponseEntity<ResponseMessage> addToCartService(Cart cartItem) {
        cartRepository.save(cartItem);

        responseMessage.setSuccess(true);
        responseMessage.setMessage("Item added to cart");

        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);

    }

    public List<Cart> getItemFromCart(int userId) {
        return cartRepository.findByUserId(userId);
    }
}
