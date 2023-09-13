package com.project.fooddeliveryservice.controller;

import com.project.fooddeliveryservice.data.CompanyFoodCategory;
import com.project.fooddeliveryservice.service.ICompanyFoodCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("food_categories/")
@RequiredArgsConstructor
public class CompanyFoodCategoryController {
    private final ICompanyFoodCategoryService foodCategoryService;

    @GetMapping("/")
    public List<CompanyFoodCategory> getAllFoodCategories() {
        return foodCategoryService.getAllFoodCategories();
    }


    @PostMapping("/company/{id}")
    public CompanyFoodCategory createFoodCategoryByCompanyId(@PathVariable long id, @RequestBody CompanyFoodCategory foodCategory) {
        return foodCategoryService.createFoodCategoryByCompanyId(id, foodCategory);
    }

    @PutMapping("/{id}")
    public CompanyFoodCategory updateFoodCategory(@PathVariable long id, @RequestBody CompanyFoodCategory foodCategory) {
        return foodCategoryService.updateFoodCategoryById(id, foodCategory);
    }

    @DeleteMapping("/{id}")
    public String deleteFoodCategory(@PathVariable long id) {
        foodCategoryService.deleteFoodCategoryById(id);
        return "Food category was successfully deleted!";
    }
}
