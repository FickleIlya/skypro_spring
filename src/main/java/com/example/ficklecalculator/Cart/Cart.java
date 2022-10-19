package com.example.ficklecalculator.Cart;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
@Scope("prototype")
public class Cart {
    private Map<String, Long> cartItems;

    public Map<String, Long> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<String> itemIds) {

        this.cartItems = listToMapWithCountKeys(itemIds);
    }

    private static <K>  Map<K, Long> listToMapWithCountKeys(List<K> list){

        return (Map<K, Long>) list.stream().collect(
                Collectors.groupingBy(s -> s, Collectors.counting()));
    }
}
