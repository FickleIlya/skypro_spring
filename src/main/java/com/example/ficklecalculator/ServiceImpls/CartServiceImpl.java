package com.example.ficklecalculator.ServiceImpls;

import com.example.ficklecalculator.Cart.Cart;
import com.example.ficklecalculator.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Map;

@Service
@SessionScope
public class CartServiceImpl implements CartService {

    private final Cart cart;

    @Autowired
    public CartServiceImpl(Cart cart){
        this.cart = cart;
    }

    @Override
    public Map<String, Long> getCartItems() {
        return cart.getCartItems();
    }

    @Override
    public void addToCart(List<String> itemIds){
        cart.setCartItems(itemIds);
    }
}
