package com.project.fooddeliveryservice.database;

import com.project.fooddeliveryservice.data.Company;
import com.project.fooddeliveryservice.data.CompanyFoodCategory;
import com.project.fooddeliveryservice.repository.CompanyFoodCategoryRepository;
import com.project.fooddeliveryservice.repository.CompanyRepository;
import com.project.fooddeliveryservice.service.CompanyFoodCategoryService;
import com.project.fooddeliveryservice.service.CompanyService;

import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyFoodCategoryRepositoryTest {
    @Autowired
    private CompanyFoodCategoryRepository foodCategoryRepository;

    @Autowired
    private CompanyFoodCategoryService foodCategoryService;

    @Autowired
    private CompanyRepository companyRepository;

    private Company createCompany(String name, String category, String logoPath) {
        Company company = new Company();
        company.setCategory(category);
        company.setName(name);
        company.setLogoPath(logoPath);
        return company;
    }

    private CompanyFoodCategory createFoodCategory(Company company) {
        CompanyFoodCategory foodCategory = new CompanyFoodCategory();
        foodCategory.setCompany(company);
        foodCategory.setName("Burgers");
        return foodCategory;
    }

    @Test
    @DisplayName("create food category")
    public void itShouldCreateOrSaveFoodCategory() {
        Company company = createCompany("KFC", "Fast Food Restaurant", "www.example.com/images/example.jpg");
        company = companyRepository.save(company);
        CompanyFoodCategory foodCategory = createFoodCategory(company);
        foodCategoryRepository.save(foodCategory);
        assertTrue(foodCategoryRepository.existsById(foodCategory.getId()));
    }

    @Test
    @DisplayName("find food category by id")
    public void itShouldFindFoodCategoryById() {
        Company company = createCompany("KFC", "Fast Food Restaurant", "www.example.com/images/example.jpg");
        company = companyRepository.save(company);
        CompanyFoodCategory foodCategory = createFoodCategory(company);
        foodCategoryRepository.save(foodCategory);
        boolean assertCondition = foodCategory.toString().equals(foodCategoryRepository.findById(foodCategory.getId()).toString());
        assertTrue(assertCondition);
    }
}
