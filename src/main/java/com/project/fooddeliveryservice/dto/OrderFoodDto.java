package com.project.fooddeliveryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderFoodDto {
    private FoodDto food;
    private int quantity;
    private double subtotal;


}
