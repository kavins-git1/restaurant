package com.kvn.Restaurent.controller;

import com.kvn.Restaurent.dto.RestaurentDto;
import com.kvn.Restaurent.model.Restaurant;
import com.kvn.Restaurent.model.User;
import com.kvn.Restaurent.request.CreateRestaurantRequest;
import com.kvn.Restaurent.service.RestaurantService;
import com.kvn.Restaurent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(
            @RequestHeader("Authorization") String jwt,
            @RequestParam String keyword
    ) throws Exception {

        User user=userService.findUserByJwtToken(jwt);

        List<Restaurant> restaurant=restaurantService.searchRestaurant(keyword);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<List<Restaurant>>getAllRestaurant(
            @RequestHeader("Authorization") String jwt
    ) throws Exception {

        User user=userService.findUserByJwtToken(jwt);

        List<Restaurant> restaurant=restaurantService.getAllRestaurant();
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Restaurant>findRestaurantBYId(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception {

        User user=userService.findUserByJwtToken(jwt);

        Restaurant restaurant=restaurantService.findRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/{id}/add-favorites")
    public ResponseEntity<RestaurentDto>addToFavorites(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception {

        User user=userService.findUserByJwtToken(jwt);

        RestaurentDto restaurant=restaurantService.addtoFavorites(id,user);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

}
