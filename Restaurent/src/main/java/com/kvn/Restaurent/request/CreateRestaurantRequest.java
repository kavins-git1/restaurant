package com.kvn.Restaurent.request;


import com.kvn.Restaurent.model.Address;
import com.kvn.Restaurent.model.ContactInformation;
import lombok.Data;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Data
public class CreateRestaurantRequest {

    private Long id;

    private  String name;
    private String description;
    private String cuisineType;
    private Address address;
    private ContactInformation contactInformation;
    private  String openingHours;
    private List<String> images;


}
