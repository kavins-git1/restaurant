package com.kvn.Restaurent.controller;

import com.kvn.Restaurent.model.Food;
import com.kvn.Restaurent.model.Restaurant;
import com.kvn.Restaurent.model.User;
import com.kvn.Restaurent.request.CreateFoodRequest;
import com.kvn.Restaurent.service.FoodService;
import com.kvn.Restaurent.service.RestaurantService;
import com.kvn.Restaurent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private UserService userService;
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String name,
                                                 @RequestHeader("Authorization")String jwt) throws Exception{
        User user=userService.findUserByJwtToken(jwt);
        List<Food> food=foodService.searchFood(name);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getRestaurantFood(@RequestParam boolean vegetarian,
                                                 @RequestParam boolean seasonal,
                                                 @RequestParam boolean nonveg,
                                                 @RequestParam(required = false) String food_category,
                                                 @RequestParam Long restaurantId,
                                                 @RequestHeader("Authorization")String jwt) throws Exception{
        User user=userService.findUserByJwtToken(jwt);
        List<Food> food=foodService.getRestaurantsFood(restaurantId,vegetarian,nonveg,seasonal,food_category);

        return new ResponseEntity<>(food, HttpStatus.OK);
    }
}
