package com.kvn.Restaurent.service;

import com.kvn.Restaurent.model.IngredientCategory;
import com.kvn.Restaurent.model.IngredientItem;

import java.util.List;

public interface IngredientsService {

    public IngredientCategory createIngredientCategory(String name,Long restaurantId)throws Exception;

    public IngredientCategory findIngredientCategoryById(Long id)throws Exception;

    public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id)throws Exception;

    public IngredientItem createIngredientItem(Long restaurantId,String ingredientName,Long categoryId) throws Exception;

    public List<IngredientItem> findRestaurantsIngredient(Long restaurantId);

    public IngredientItem updateStock(Long id) throws Exception;
}
