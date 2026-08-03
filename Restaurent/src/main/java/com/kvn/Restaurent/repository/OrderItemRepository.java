package com.kvn.Restaurent.repository;


import com.kvn.Restaurent.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
