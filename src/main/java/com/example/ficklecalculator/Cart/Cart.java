package com.example.ficklecalculator.Cart;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@SessionScope
public class Cart {
    private final Map<String, Long> cartItems;

    public Map<String, Long> getCartItems() {
        return cartItems;
    }

    public void addToCart(List<String> itemIds) {
        Map<String, Long> newItems = listToMapWithCountKeys(itemIds);
        newItems.forEach((key, value) -> cartItems.merge(key, value, Long::sum));
    }

    private static <K>  Map<K, Long> listToMapWithCountKeys(List<K> list){

        return list.stream().collect(
                Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    public Cart() {
        cartItems = new HashMap<>();
    }
}
