package com.project.fooddeliveryservice.service;

import com.project.fooddeliveryservice.data.Food;
import com.project.fooddeliveryservice.repository.CompanyFoodCategoryRepository;
import com.project.fooddeliveryservice.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService implements IFoodService {
    private final FoodRepository foodRepo;
    private final CompanyFoodCategoryRepository foodCategoryRepo;

    @Override
    public Food createFood(long foodCategoryId, Food food) {
//        food.setFoodCategory(foodCategoryRepo.findById(foodCategoryId));
        food.setCompanyFoodCategory(foodCategoryRepo.findById(foodCategoryId));
        return foodRepo.save(food);
    }

    @Override
    public void deleteFoodById(long id) {
        foodRepo.deleteById(id);
    }

    @Override
    public List<Food> getAllFood() {
        return foodRepo.findAll();
    }

    @Override
    public Food getFoodById(long id) {
        return foodRepo.findById(id);
    }

    @Override
    public Food updateFoodById(long id, Food food) {
        Food foundFood = foodRepo.findById(id);
        foundFood.setName(food.getName());
        foundFood.setDescription(food.getDescription());
        foundFood.setImagePath(food.getImagePath());
        foundFood.setPrice(food.getPrice());
        return foodRepo.save(foundFood);
    }
}
