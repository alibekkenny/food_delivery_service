package com.project.fooddeliveryservice.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "orderFoods")
public class OrderFood {
    @EmbeddedId
    OrderFoodKey id;
    private int quantity;
    private double subtotal;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id", nullable = false)
//    @JsonIgnore
    @ToString.Exclude
    private Order order;

    @ManyToOne
    @MapsId("foodId")
    @JoinColumn(name = "food_id", nullable = false)
//    @JsonIgnore
    @ToString.Exclude
    private Food food;
}
