package com.kvn.Restaurent.service;

import com.kvn.Restaurent.model.Category;

import java.util.List;

public interface  CategoryService {
    public Category createCategory(String name,Long userId)throws Exception;

    public List<Category> findCategoryByRestaurantId(Long id) throws Exception;

    public Category findCategoryById(Long id)throws Exception;
}
