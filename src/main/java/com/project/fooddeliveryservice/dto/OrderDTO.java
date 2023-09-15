package com.project.fooddeliveryservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private long id;
    @JsonProperty("total_cost")
    private double totalCost;
    @JsonProperty("order_time")
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime orderTime;
    @JsonProperty("delivery_time")
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime deliveryTime;
    private String address;
    @JsonProperty("user_id")
    private long userId;
    @JsonProperty("order_foods")
    private List<OrderFoodDTO> orderFoods;
}
