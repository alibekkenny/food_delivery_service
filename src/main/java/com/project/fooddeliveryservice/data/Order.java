package com.project.fooddeliveryservice.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double totalCost;
    private LocalDateTime orderTime;
    private LocalDateTime deliveryTime;
    private String address;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = true)
//    @JsonIgnore
//    @ToString.Exclude
    private User user;

    @OneToMany(mappedBy = "order")
//    @JsonIgnore
    @ToString.Exclude
    private List<OrderFood> orderFoodList;
}
