package com.project.fooddeliveryservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDto {
    private Long id;
    //    @JsonProperty("total_cost")
    private double totalCost;
    //    @JsonProperty("order_time")
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime orderTime;
    //    @JsonProperty("delivery_time")
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime deliveryTime;
    private String address;
    @JsonProperty("userId")
    private Long userId;
    //        @JsonProperty("order_foods")
    private List<OrderFoodDto> orderFoods;
}
