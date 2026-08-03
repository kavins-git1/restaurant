package com.kvn.Restaurent.service;

import com.kvn.Restaurent.model.Category;
import com.kvn.Restaurent.model.Food;
import com.kvn.Restaurent.model.Restaurant;
import com.kvn.Restaurent.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);
        void deleteFood(Long foodId) throws Exception;
        public List<Food> getRestaurantsFood(Long restaurantId,
                                             boolean isVegitarian,
                                             boolean isNonveg,
                                             boolean isSeasonal,
                                             String foodCategory);

        public List<Food> searchFood(String keyword);
        public Food findFooodById(Long foodId) throws Exception;
        public Food updateAvailabilityStatus(Long foodId)throws Exception;

}
