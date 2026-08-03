package com.kvn.Restaurent.request;

import com.kvn.Restaurent.model.Category;
import com.kvn.Restaurent.model.IngredientItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {
    private String name;
    private String description;
    private Long price;
    private Category category;
    private List<String> images;
    private Long restaurantId;
    private boolean vegitarian;
    private boolean seasional;
    private List<IngredientItem> ingredients;
}
