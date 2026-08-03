package com.kvn.Restaurent.repository;

import com.kvn.Restaurent.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
    public Cart findByCustomerId(Long userId);

}
