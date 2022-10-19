package com.example.ficklecalculator.Services;


import java.util.List;
import java.util.Map;

public interface CartService {
    Map<String, Long> getCartItems();
    void addToCart(List<String> itemIds);
}
