package com.microservice.ecommerce.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ecommerce.Models.Cart;
import com.microservice.ecommerce.Models.ResponseMessage;
import com.microservice.ecommerce.Services.CartService;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("additemtocart")
    public ResponseEntity<ResponseMessage> addItemToCart(@RequestHeader String productId, @RequestHeader int userId) {
        Cart cartItem = new Cart();
        cartItem.setProductId(UUID.fromString(productId));
        cartItem.setUserId(userId);

        return cartService.addToCartService(cartItem);

    }


    @GetMapping("getcartitems")
    public List<Cart> getCartItems(@RequestHeader int userId)
    {
        return cartService.getItemFromCart(userId);
    }
}
