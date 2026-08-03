package com.kvn.Restaurent.repository;

import com.kvn.Restaurent.model.Cart;
import com.kvn.Restaurent.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    public Cart findByCustomerId(Long userId);

}
