package com.project.fooddeliveryservice.database;

import com.project.fooddeliveryservice.data.Company;
import com.project.fooddeliveryservice.data.CompanyFoodCategory;
import com.project.fooddeliveryservice.data.Food;
import com.project.fooddeliveryservice.repository.CompanyFoodCategoryRepository;
import com.project.fooddeliveryservice.repository.CompanyRepository;
import com.project.fooddeliveryservice.repository.FoodRepository;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodRepositoryTest {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyFoodCategoryRepository foodCategoryRepository;

    private Company createCompany() {
        Company company = new Company();
        company.setCategory("Fast Food Restaurant");
        company.setName("Chum Bucket");
        company.setLogoPath("www.example.com/images/image_123.png");
        return company;
    }

    private CompanyFoodCategory createFoodCategory(Company company) {
        CompanyFoodCategory foodCategory = new CompanyFoodCategory();
        foodCategory.setCompany(company);
        foodCategory.setName("Burgers");
        return foodCategory;
    }

    private Food createFood(CompanyFoodCategory foodCategory) {
        Food food = new Food();
        food.setCompanyFoodCategory(foodCategory);
        food.setPrice(10.21);
        food.setName("Krabby Patty");
        food.setDescription("Krabby Patty best offer from our company!");
        food.setImagePath("www.example.com/images/krabby_patty.png");
        return food;
    }

    @Test
    @DisplayName("Create Food")
    public void itShouldCreateFood() {
        Company company = createCompany();
        companyRepository.save(company);
        CompanyFoodCategory foodCategory = createFoodCategory(company);
        foodCategoryRepository.save(foodCategory);
        Food food = createFood(foodCategory);
        foodRepository.save(food);
        boolean condition = foodRepository.existsById(food.getId());
        assertTrue(condition);
    }

    //      Food findById(@Param("id") long id);
    @Test
    @DisplayName("Find Food by id")
    public void itShouldFindFoodById() {
        Company company = createCompany();
        companyRepository.save(company);
        CompanyFoodCategory foodCategory = createFoodCategory(company);
        foodCategoryRepository.save(foodCategory);
        Food food = createFood(foodCategory);
        foodRepository.save(food);
        boolean condition = foodRepository.findById(food.getId()).toString().equals(food.toString());
        assertTrue(condition);
    }
}
