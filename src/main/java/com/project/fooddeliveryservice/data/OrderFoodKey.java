package com.project.fooddeliveryservice.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class OrderFoodKey implements Serializable {
    @Column(name = "order_id")
    private long orderId;
    @Column(name = "food_id")
    private long foodId;
}
