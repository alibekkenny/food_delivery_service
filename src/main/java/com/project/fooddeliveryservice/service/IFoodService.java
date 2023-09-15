package com.project.fooddeliveryservice.service;


import com.project.fooddeliveryservice.data.Food;

import java.util.List;

public interface IFoodService {
    Food createFood(long foodCategoryIdFood, Food food);

    void deleteFoodById(long id);

    List<Food> getAllFood();

    Food getFoodById(long id);

    Food updateFoodById(long id, Food food);

}
