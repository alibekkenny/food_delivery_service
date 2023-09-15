package com.project.fooddeliveryservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {
    private long id;
    private String name;
    private String description;
    private double price;
    @JsonProperty("image_path")
    private String imagePath;
    @JsonProperty("food_category_id")
    private long foodCategoryId;
}
