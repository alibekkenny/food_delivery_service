package com.project.fooddeliveryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderFoodDTO {
    private FoodDTO food;
    private int quantity;
    private double subtotal;


}
