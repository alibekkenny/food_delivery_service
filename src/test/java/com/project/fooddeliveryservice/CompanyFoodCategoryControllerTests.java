package com.project.fooddeliveryservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.fooddeliveryservice.controller.CompanyController;
import com.project.fooddeliveryservice.data.Company;
import com.project.fooddeliveryservice.data.CompanyFoodCategory;
import com.project.fooddeliveryservice.dto.CompanyDto;
import com.project.fooddeliveryservice.dto.CompanyFoodCategoryDto;
import com.project.fooddeliveryservice.service.CompanyFoodCategoryService;
import com.project.fooddeliveryservice.service.CompanyService;
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
    public void itShouldCreateCompanyFoodCategory() throws Exception {
        CompanyFoodCategory companyFoodCategory = new CompanyFoodCategory();

        companyFoodCategory.setName("Combos");

        CompanyFoodCategoryDto companyFoodCategoryDto = new CompanyFoodCategoryDto();

        companyFoodCategoryDto.setName("Combos");

        when(companyFoodCategoryService.createOrSaveFoodCategory(any(CompanyFoodCategory.class))).thenReturn(companyFoodCategory);
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
                        content().string(objectMapper.writeValueAsString(foodCategories)));
    }

}
