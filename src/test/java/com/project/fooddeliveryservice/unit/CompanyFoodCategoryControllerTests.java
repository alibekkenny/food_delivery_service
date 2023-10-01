package com.project.fooddeliveryservice.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.fooddeliveryservice.data.Company;
import com.project.fooddeliveryservice.data.CompanyFoodCategory;
import com.project.fooddeliveryservice.data.Food;
import com.project.fooddeliveryservice.dto.CompanyFoodCategoryDto;
import com.project.fooddeliveryservice.service.CompanyFoodCategoryService;
import com.project.fooddeliveryservice.util.CompanyFoodCategoryListMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CompanyFoodCategory.class)
public class CompanyFoodCategoryControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private CompanyFoodCategoryService companyFoodCategoryService;


    @Test
    @Disabled
    public void itShouldCreateCompanyFoodCategory() throws Exception {
        Company company = new Company();
        company.setId(1);
        Food food = new Food();
        food.setId(1);
        CompanyFoodCategory companyFoodCategory = new CompanyFoodCategory();

        companyFoodCategory.setName("Combos");
        companyFoodCategory.setCompany(company);

        CompanyFoodCategoryDto companyFoodCategoryDto = new CompanyFoodCategoryDto();

        companyFoodCategoryDto.setName("Combos");
        companyFoodCategoryDto.setCompanyId(company.getId());
//        companyFoodCategoryDto.setFoods();
        when(companyFoodCategoryService.createFoodCategory(any(CompanyFoodCategory.class))).thenReturn(companyFoodCategory);
        mockMvc.perform(post("/food_categories")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(companyFoodCategoryDto)))
                .andExpectAll(
                        status().is(200),
                        content().contentType(APPLICATION_JSON),
                        jsonPath("$.name").value(companyFoodCategory.getName()));
    }

    @Test

    public void itShouldGetAllCompanies() throws Exception {
        var foodCategories = List.of(new CompanyFoodCategory(), new CompanyFoodCategory(), new CompanyFoodCategory());
        when(companyFoodCategoryService.getAllFoodCategories()).thenReturn(foodCategories);

        mockMvc.perform(get("/food_categories"))
                .andExpectAll(
                        status().is(200),
                        content().contentType(APPLICATION_JSON),
                        content().string(objectMapper.writeValueAsString(CompanyFoodCategoryListMapper.INSTANCE.companyFoodCategoryListToCompanyFoodCategoryListDto(foodCategories))));
    }

}
