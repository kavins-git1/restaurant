package com.kvn.Restaurent.request;


import com.kvn.Restaurent.model.Address;
import lombok.Data;

@Data
public class OrderRequest {
    private Long restaurantId;
    private Address deliveryAddress;
}
