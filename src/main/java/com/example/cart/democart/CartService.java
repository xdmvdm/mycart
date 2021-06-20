package com.example.cart.democart;

import java.util.List;

public interface CartService {
    List<Cart> getAllCartItems();

    Cart getCartById(String cartId);

    Cart addCartItem(Cart cart);

    Cart saveOrUpdateCart(Cart cart);

    Cart deleteCartItem(Cart cart);

    Long deleteCartItem(Long cartId);

    Long findTopByOrderByIdDesc();
}
