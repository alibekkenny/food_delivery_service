package com.project.fooddeliveryservice.controller;

import com.project.fooddeliveryservice.data.CompanyFoodCategory;
import com.project.fooddeliveryservice.dto.CompanyDto;
import com.project.fooddeliveryservice.dto.CompanyFoodCategoryDto;
import com.project.fooddeliveryservice.service.ICompanyFoodCategoryService;
import com.project.fooddeliveryservice.util.CompanyFoodCategoryListMapper;
import com.project.fooddeliveryservice.util.CompanyFoodCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
@RequestMapping("/food_categories")
public class CompanyFoodCategoryController {
    private final ICompanyFoodCategoryService foodCategoryService;

    @GetMapping("/")
    List<CompanyFoodCategoryDto> getAllFoodCategories() {
        return CompanyFoodCategoryListMapper.INSTANCE.companyFoodCategoryListToCompanyFoodCategoryListDto(foodCategoryService.getAllFoodCategories());
    }

    @PostMapping("/")
    CompanyFoodCategoryDto createFoodCategory(CompanyFoodCategoryDto foodCategory) {
        return CompanyFoodCategoryMapper.INSTANCE.companyFoodCategoryToCompanyFoodCategoryDto(
                foodCategoryService.createOrSaveFoodCategory(CompanyFoodCategoryMapper.INSTANCE.companyFoodCategoryDtoToCompanyFoodCategory(foodCategory))
        );
    }
}
