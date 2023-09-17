package com.project.fooddeliveryservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyFoodCategoryDto {
    private Long id;
    private String name;

    //    @JsonProperty("company_id")
    private Long companyId;
    private List<FoodDto> foods;
}
