package com.example.ficklecalculator.Controllers;

import com.example.ficklecalculator.Services.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/store/order")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/add")
    public void addToCart(@RequestParam List<String> itemIds) {
        cartService.addToCart(itemIds);
    }

    @GetMapping("/get")
    public String getCartItems() throws JsonProcessingException {
        Map<String, Long> cart = cartService.getCartItems();
        return new ObjectMapper().writeValueAsString(cart);
    }
}
