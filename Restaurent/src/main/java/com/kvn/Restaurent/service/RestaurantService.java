package com.kvn.Restaurent.service;

import com.kvn.Restaurent.dto.RestaurentDto;
import com.kvn.Restaurent.model.Restaurant;
import com.kvn.Restaurent.model.User;
import com.kvn.Restaurent.request.CreateRestaurantRequest;

import java.util.List;

public interface RestaurantService {

    public Restaurant createRestaurant(CreateRestaurantRequest req, User user );

    public Restaurant updateRestaurant(Long restaurantId,CreateRestaurantRequest updateRestaurant) throws Exception;

    public void deleteRestaurant(Long restaurantId) throws Exception;

    public List<Restaurant> getAllRestaurant();

    public List<Restaurant> searchRestaurant(String keyword);

    public  Restaurant findRestaurantById(Long id ) throws Exception;

    public Restaurant getRestaurantByUserId(Long userId)  throws Exception;

    public RestaurentDto addtoFavorites(Long restaurantId,User user) throws Exception;

    public Restaurant updateRestaurantStatus(Long id) throws Exception;


}
