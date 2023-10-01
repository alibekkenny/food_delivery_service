package com.project.fooddeliveryservice.service;

import com.project.fooddeliveryservice.data.CompanyFoodCategory;

import java.util.List;

public interface ICompanyFoodCategoryService {
    CompanyFoodCategory createFoodCategory(CompanyFoodCategory foodCategory);

    CompanyFoodCategory createOrSaveFoodCategory(CompanyFoodCategory foodCategory);

//    CompanyFoodCategory updateFoodCategoryById(long id, CompanyFoodCategory foodCategory);

    List<CompanyFoodCategory> getAllFoodCategories();

    void deleteFoodCategoryById(long id);

}
