package com.kvn.Restaurent.service;

import com.kvn.Restaurent.model.Category;
import com.kvn.Restaurent.model.Food;
import com.kvn.Restaurent.model.Restaurant;
import com.kvn.Restaurent.repository.FoodRepository;
import com.kvn.Restaurent.request.CreateFoodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
@Service
public class FoodServiceImp implements FoodService{
    @Autowired
    private FoodRepository foodRepository;


    @Override
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) {
        Food food=new Food();
        food.setFoodCategory(category);
        food.setRestaurant(restaurant);
        food.setDescription(req.getDescription());
        food.setImages(req.getImages());
        food.setName(req.getName());
        food.setPrice(req.getPrice());
        food.setIngredients(req.getIngredients());
        food.setSeasonal(req.isSeasional());
        food.setVegetarian(req.isVegitarian());


        Food  savedFood  = foodRepository.save(food);
        restaurant.getFoods().add(savedFood);
        return savedFood;
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {
        Food food=findFooodById(foodId);
        food.setRestaurant(null);
        foodRepository.save(food);
    }

    @Override
    public List<Food> getRestaurantsFood(Long restaurantId,
                                         boolean isVegitarian,
                                         boolean isNonveg,
                                         boolean isSeasonal,
                                         String foodCategory) {
        List<Food> foods=foodRepository.findByRestaurantId(restaurantId);

        if(isVegitarian){
            foods=filterByVegitarian(foods,isVegitarian);
        }
        if(isNonveg){
            foods=filterByNonveg(foods,isNonveg);
        }

        if(isSeasonal){
            foods=filterBySeasonal(foods,isSeasonal);
        }
        if(foodCategory !=null && !foodCategory.equals("")){
            foods=filterByCategory(foods,foodCategory);
        }
        return foods;
    }

    private List<Food> filterByCategory(List<Food> foods, String foodCategory) {
        return foods.stream().filter(food -> {
            if(food.getFoodCategory()!=null){
                return food.getFoodCategory().getName().equals(foodCategory);
            }
            return  false;
        }).collect(Collectors.toList());
    }

    private List<Food> filterByVegitarian(List<Food> foods, boolean isVegitarian) {
        return foods.stream()
                .filter(food -> food.isVegetarian()==isVegitarian)
                .collect(Collectors.toList());
    }

    private List<Food> filterByNonveg(List<Food> foods, boolean isNonveg) {
        return  foods.stream()
                .filter(food -> food.isVegetarian()==false)
                .collect(Collectors.toList());
    }

    private List<Food> filterBySeasonal(List<Food> foods, boolean isSeasonal) {
        return  foods.stream()
                .filter(food -> food.isSeasonal()==isSeasonal)
                .collect(Collectors.toList());
    }

    @Override
    public List<Food> searchFood(String keyword) {

        return foodRepository.searcFood(keyword);
    }

    @Override
    public Food findFooodById(Long foodId) throws Exception {
        Optional<Food> optionalFood=foodRepository.findById(foodId);
        if(optionalFood.isEmpty()){
            throw new Exception("food not exists...");
        }
        return optionalFood.get();
    }

    @Override
    public Food updateAvailabilityStatus(Long foodId) throws Exception {
        Food food=findFooodById(foodId);
        food.setAvailable(!food.isAvailable());
        return foodRepository.save(food);

    }
}
