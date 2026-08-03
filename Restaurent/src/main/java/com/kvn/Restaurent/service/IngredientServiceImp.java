package com.kvn.Restaurent.service;

import com.kvn.Restaurent.model.IngredientCategory;
import com.kvn.Restaurent.model.IngredientItem;
import com.kvn.Restaurent.model.Restaurant;
import com.kvn.Restaurent.repository.IngredientCategoryRepository;
import com.kvn.Restaurent.repository.IngredientItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IngredientServiceImp implements IngredientsService {
    @Autowired
    private IngredientItemRepository ingredientItemRepository;

    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Override
    public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception {

        Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
        IngredientCategory category=new IngredientCategory();
        category.setRestaurant(restaurant);
        category.setName(name);
        return ingredientCategoryRepository.save(category);
    }

    @Override
    public IngredientCategory findIngredientCategoryById(Long id) throws Exception {
        Optional<IngredientCategory> opt=ingredientCategoryRepository.findById(id);
        if(opt.isEmpty()){
            throw new Exception("ingredient category not found");
        }
        return opt.get();
    }

    @Override
    public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception {
        restaurantService.findRestaurantById(id);
        return ingredientCategoryRepository.findByRestaurantId(id);
    }

    @Override
    public IngredientItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception {
        Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
        IngredientCategory category=findIngredientCategoryById(categoryId);

        IngredientItem item=new IngredientItem();
        item.setName(ingredientName);
        item.setRestaurant(restaurant);
        item.setCategory(category);

        IngredientItem ingredient=ingredientItemRepository.save(item);
        category.getIngredients().add(ingredient);
        return ingredient;
    }

    @Override
    public List<IngredientItem> findRestaurantsIngredient(Long restaurantId) {
        return ingredientItemRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public IngredientItem updateStock(Long id) throws Exception {

        Optional<IngredientItem> optionalIngredientItem=ingredientItemRepository.findById(id);
        if(optionalIngredientItem.isEmpty()){
            throw new Exception("ingredient not found");
        }
        IngredientItem ingredientItem=optionalIngredientItem.get();
        ingredientItem.setInStoke(!ingredientItem.isInStoke());
        return ingredientItemRepository.save(ingredientItem);
    }


}
