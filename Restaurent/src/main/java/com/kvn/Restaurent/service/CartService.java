package com.kvn.Restaurent.service;

import com.kvn.Restaurent.model.Cart;
import com.kvn.Restaurent.model.CartItem;
import com.kvn.Restaurent.request.AddCartItemRequest;

public interface CartService {
    public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception;

    public CartItem updateCartItemQuantity(Long cartItemId, int quantity) throws Exception;

    public Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception;

    public Long calculateCartTotals(Cart cart) throws Exception;

    public Cart findCartById(Long id) throws Exception;

    public Cart findCartByuserId(Long userId) throws Exception;

    public Cart clearCart(Long userId) throws Exception;

}