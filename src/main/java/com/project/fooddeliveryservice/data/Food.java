package com.project.fooddeliveryservice.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "food_id")
    private long id;
    private String name;
    private String description;
    private double price;
    private String imagePath;

    @ManyToOne
//    @MapsId("companyFoodCategoryId")
    @JoinColumn(name = "companyfoodcategory_id", nullable = false)
//    @JsonIgnore
    @ToString.Exclude
    CompanyFoodCategory companyFoodCategory;


}
