package com.project.fooddeliveryservice.service;

import com.project.fooddeliveryservice.data.CompanyFoodCategory;
import com.project.fooddeliveryservice.repository.CompanyFoodCategoryRepository;
import com.project.fooddeliveryservice.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CompanyFoodCategoryService implements ICompanyFoodCategoryService {
    private final CompanyFoodCategoryRepository foodCategoryRepo;
    private final CompanyRepository companyRepo;

    @Override
    public List<CompanyFoodCategory> getAllFoodCategories() {
        return foodCategoryRepo.findAll();
    }


    @Override
    public void deleteFoodCategoryById(long id) {
        foodCategoryRepo.deleteById(id);
    }

    @Override
    public CompanyFoodCategory createFoodCategory(CompanyFoodCategory foodCategory) {
        if (companyRepo.existsById(foodCategory.getCompany().getId())) {
            foodCategory.setCompany(companyRepo.findById(foodCategory.getCompany().getId()));
        }
        return foodCategoryRepo.save(foodCategory);
    }

    @Override
    public CompanyFoodCategory createOrSaveFoodCategory(CompanyFoodCategory foodCategory) {
        return foodCategoryRepo.save(foodCategory);
    }

//    @Override
//    public CompanyFoodCategory updateFoodCategoryById(long id, CompanyFoodCategory foodCategory) {
//        CompanyFoodCategory foundFoodCategory = foodCategoryRepo.findById(id);
//        if (!Objects.equals(foodCategory.getName(), "")) {
//            foodCategory.setName(foodCategory.getName());
//        }
//        return foodCategoryRepo.save(foundFoodCategory);
//    }


}
